# Hardware Store Manager

Application de bureau Java (Swing) de **gestion d'une quincaillerie** : produits, stock, clients, personnel, commandes et factures. Projet d'étudiant réalisé en 2022 pour un cours de programmation orientée objet (APOO), à partir du cahier des charges de [`Documentation/Cahier_de_charges.pdf`](Documentation/Cahier_de_charges.pdf).

> Projet pédagogique : ce n'est pas un produit fini. Voir « Limites connues » avant toute utilisation autre que la démonstration.

## Fonctionnalités

- Connexion par compte, avec deux rôles : `Gerant` et `Comptable`.
- Gestion des **produits**, du **stock** (entrées par date et quantité), des **clients** et des **employés** (avec photo).
- Gestion des **commandes** et de leurs lignes (produit, quantité, prix) et des **factures**.
- Gestion des comptes **utilisateurs**.
- Gabarit de facture JasperReports : [`src/View/JasperReports/BillPdf.jrxml`](src/View/JasperReports/BillPdf.jrxml).

## Stack technique

- Java (projet NetBeans, ant, cible `javac` 1.8), interface **Swing** conçue avec l'éditeur de formulaires NetBeans (fichiers `.form`).
- Architecture **MVC** : `Models/Entities` (entités), `Models/EntitiesManagers` (accès aux données en JDBC), `Controllers`, `View` (fenêtres et panneaux).
- **MySQL** via `mysql-connector-java` 8.0.26, plus `jcalendar` (sélecteur de dates) et `rs2xml` (tableaux) fournis dans `lib/`.

## Prérequis

- JDK 8 ou plus récent, et NetBeans (ou `ant`) pour ouvrir et compiler le projet.
- Un serveur MySQL en local, port 3306.
- Les bibliothèques JasperReports référencées par `nbproject/project.properties` (dossier `lib/jasper library/`) ne sont **pas** dans le dépôt : il faut les ajouter si vous voulez compiler avec la génération de factures.

## Installation et lancement

1. Créer la base : exécuter [`src/Main/DatabaseCreator.sql`](src/Main/DatabaseCreator.sql) dans MySQL (il crée la base `hardware_store_manager`, l'utilisateur `hardware_store_manager_user`, les tables et deux comptes de démonstration).
2. Ouvrir le dossier dans NetBeans, puis exécuter le projet (classe principale `Main.Main`). Avec ant : `ant jar`.

## Configuration

Les paramètres de connexion sont écrits en dur dans [`src/Models/EntitiesManagers/Manager.java`](src/Models/EntitiesManagers/Manager.java) : `jdbc:mysql://localhost:3306/hardware_store_manager`, utilisateur `hardware_store_manager_user`. Changez-les là si votre base est différente.

## Structure

```
src/
├── Main/            # point d'entrée (Main.java) et script SQL de la base
├── Models/
│   ├── Entities/            # Product, Stock, Client, Employer, Order, OrderDetails, Bill, User
│   └── EntitiesManagers/    # accès MySQL de chaque entité
├── Controllers/     # logique entre vues et modèles
└── View/            # fenêtres (JFrames), panneaux (JPanels), images, gabarit de facture
Documentation/       # cahier des charges, rapport (docx), notes sur la base de données
lib/                 # pilotes et bibliothèques Swing
nbproject/, build/   # fichiers NetBeans et sorties de compilation
```

## Limites connues

- Les mots de passe sont **stockés en clair** dans la base et le script SQL contient des comptes de démonstration : à ne jamais réutiliser tels quels.
- Identifiants MySQL en dur dans le code, pas de tests automatisés.
- Projet de 2022, non maintenu.

## Licence

Code publié sous licence MIT : voir [LICENSE](LICENSE).

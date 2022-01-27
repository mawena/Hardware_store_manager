package Controllers;

import Models.Entities.Client;
import Models.EntitiesManagers.ClientsManager;
import javax.swing.JOptionPane;

public class ClientsController {

    public static boolean isValid(Client client) {
        boolean rep = true;
        if (client.getNumCIN().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le numéro de carte d'identié est manquant!");
        } else if (client.getLastName().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
        } else if (client.getFirstName().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le prénom est manquant!");
        } else if (client.getTel().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le numéro de téléphone est manquant!");
        }
        return rep;
    }

    public static boolean store(Client client) {
        Client cl = ClientsManager.get(client.getNumCIN());
        if (cl == null) {
            if (isValid(client)) {
                return (ClientsManager.store(client) != null);
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le client existe déjà!");
            return false;
        }
    }

    public static boolean update(int clientId, Client client) {
        Client cl = ClientsManager.get(clientId);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "Le client n'existe pas!");
            return false;
        } else {
            if (isValid(client)) {
                return (ClientsManager.update(clientId, client) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean update(String clientCNI, Client client) {
        Client cl = ClientsManager.get(clientCNI);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "Le client n'existe pas!");
            return false;
        } else {
            if (isValid(client)) {
                return (ClientsManager.update(client.getId(), client) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int clientId) {
        Client client = ClientsManager.get(clientId);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Le client sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le client?") == 0) {
                return (ClientsManager.delete(clientId));
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(String clientCIN) {
        if (clientCIN.equals("")) {
            JOptionPane.showMessageDialog(null, "Le CNI est manquant!");
            return false;
        } else {
            Client client = ClientsManager.get(clientCIN);
            if (client == null) {
                JOptionPane.showMessageDialog(null, "Le client sélectioné n'existe pas!");
                return false;
            } else {
                if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le client?") == 0) {
                    return (ClientsManager.delete(client.getId()));
                } else {
                    return false;
                }
            }
        }
    }
}

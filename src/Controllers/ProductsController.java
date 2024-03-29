package Controllers;

import Models.EntitiesManagers.ProductsManager;
import Models.Entities.Product;
import javax.swing.JOptionPane;

public class ProductsController {

    public static boolean isValid(Product product) {
        boolean rep = true;
        if (product.getDesignation().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "La designation est manquante!");
        } else if (product.getDescription().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "La description est manquante!");
        } else if (product.getPrice() <= 0) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le prix doit être supérieur à 0");
        }
        return rep;
    }

    public static boolean store(Product product) {
        Product pr = ProductsManager.get(product.getDesignation());
        if (pr == null) {
            if (isValid(product)) {
                return (ProductsManager.store(product) != null);
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le produit " + product.getDesignation() + " existe déjà!");
            return false;
        }
    }

    public static boolean update(int productId, Product product) {
        Product pr = ProductsManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
            return false;
        } else {
            if (isValid(product)) {
                return (ProductsManager.update(productId, product) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int productId) {
        Product pr = ProductsManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le client?") == 0) {
                return (ProductsManager.delete(productId));
            }
            return false;
        }
    }
}

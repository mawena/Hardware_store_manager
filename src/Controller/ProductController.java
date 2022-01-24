package Controller;

import Model.entitiesManagers.ProductManager;
import Model.entities.Product;
import javax.swing.JOptionPane;

public class ProductController {

    /**
     * Verify if a product is valid
     * 
     * @param product Product The product will be verified
     * 
     * @return boolean
     */
    public static boolean isValid(Product product) {
        boolean rep = true;
        if (product.getDesignation().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
        } else if (product.getDescription().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "La description est manquante!");
        } else if (product.getPrice() <= 0){
            rep = false;
            JOptionPane.showMessageDialog(null, "Le prix doit être supérieur à 0");
        }
        return rep;
    }

    /**
     * Insert a product into the database
     * 
     * @param product Product The product will be inserted
     * 
     * @return boolean
     */
    public static boolean store(Product product) {
    Product pr = ProductManager.get(product.getDesignation());
        if (pr == null) {
            if (isValid(product)) {
                return (ProductManager.store(product) != null);
            }else{
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ce produit " + product.getDesignation() +" existe déjà!");
            return false;
        }
    }

    /**
     * Updates a product from the database
     * 
     * @param productId Integer The id of the product will be updated
     * @param product   Product The new product
     * 
     * @return boolean
     */
    public static boolean update(int productId, Product product) {
        Product pr = ProductManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
            return false;
        } else {
            if(isValid(product)){
                return (ProductManager.update(productId, product) != null);
            }else{
                return false;
            }
        }
    }

    /**
     * Remove a product from the database
     * 
     * @param productId Integer The id of the product will be deleted
     * 
     * @return boolean
     */
    public static boolean destroy(int productId) {
        Product pr = ProductManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
            return false;
        } else {
            return (ProductManager.delete(productId) != 0);
        }
    }
}

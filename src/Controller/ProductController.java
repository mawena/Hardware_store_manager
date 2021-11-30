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
     * @return void
     */
    public static boolean isValid(Product product) {
        boolean rep = true;
        if (product.getDesignation().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
        } else if (product.getDescription().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "La description est manquante!");
        }
        return rep;
    }

    /**
     * Insert a product into the database
     * 
     * @param product Product The product will be inserted
     * 
     * @return void
     */
    public static void store(Product product) {
        Product pr = ProductManager.get(product.getId());
        if (pr == null) {
            if (isValid(product)) {
                ProductManager.store(product);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ce produit existe déjà!");
        }
    }

    /**
     * Updates a product from the database
     * 
     * @param productId Integer The id of the product will be updated
     * @param product   Product The new product
     * 
     * @return void
     */
    public static void update(int productId, Product product) {
        Product pr = ProductManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
        } else {
            ProductManager.update(productId, product);
        }
    }

    /**
     * Remove a product from the database
     * 
     * @param productId Integer The id of the product will be deleted
     * 
     * @return void
     */
    public static void destroy(int productId) {
        Product pr = ProductManager.get(productId);
        if (pr == null) {
            JOptionPane.showMessageDialog(null, "Le produit n'existe pas!");
        } else {
            ProductManager.delete(productId);
        }
    }
}

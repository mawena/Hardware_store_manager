package Model.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Model.entities.Product;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * product in the database
 * 
 * @author mawena
 */
public class ProductManager extends Manager {

    /**
     * Return a product with its id
     * 
     * @param id The product's id
     * @return Product The product found
     */
    public static Product get(int id) {
        Product product = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM products WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                product = new Product(result.getInt("id"), result.getString("designation"),
                        result.getString("description"), result.getDouble("price"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return product;
    }
    
    
    /**
     * Select product using designation
     * 
     * @param designation
     * @return 
     */
    public static Product get(String designation){
        Product product = null;
        
        try{
            pS = connection.prepareStatement("SELECT * FROM products WHERE designation = ?");
            pS.setString(1, designation);
            result = pS.executeQuery();
            while(result.next()){
                product = new Product(result.getInt("id"), result.getString("designation"), result.getString("description"), result.getDouble("price"));
            }
            closeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        
        return product;
    }

    /**
     * Return an ArrayList of all products from the database
     * 
     * @return ArrayList The ArrayList of all products
     */
    public static ArrayList<Product> getAll() {
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products;");
            while (result.next()) {
                productList.add(new Product(result.getInt("id"), result.getString("designation"),
                        result.getString("description"), result.getDouble("price")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return productList;
    }

    /**
     * Search a products
     * 
     * @param col   String  The col
     * @param value String  The value
     * @return ArrayList
     */
    public static ArrayList<Product> search(String col, String value) {
        ArrayList<Product> productList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE "+col+" LIKE '%"+value+"%';");
            while (result.next()) {
                productList.add(new Product(result.getInt("id"), result.getString("designation"),
                        result.getString("description"), result.getDouble("price")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
        return productList;
    }

    /**
     * Insert a product into the database
     * 
     * @param product The product that will be inserted
     * @return Product The product that has beenn inserted
     */
    public static Product store(Product product) {
        try {
            pS = connection.prepareStatement("INSERT INTO products(designation, description, price) VALUES(?, ?, ?);");
            pS.setString(1, product.getDesignation());
            pS.setString(2, product.getDescription());
            pS.setDouble(3, product.getPrice());
            pS.executeUpdate();
            product.setId(getLastId("products"));
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
        return product;
    }

    /**
     * Updates a product into the database
     * 
     * @param id The id of the Product that will be updated
     * @param product The new Product
     * @return Product
     */
    public static Product update(int id, Product product) {
        try {
            
            pS = connection.prepareStatement(
                    "UPDATE products SET designation = ?, description = ?, price = ? WHERE id = ?;");
            pS.setString(1, product.getDesignation());
            pS.setString(2, product.getDescription());
            pS.setDouble(3, product.getPrice());
            pS.setInt(4, id);
            pS.executeUpdate();
            JOptionPane.showMessageDialog(null, product);
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
        return product;
    }

    /**
     * Deletes a product from the database
     * 
     * @param id The product's id
     * @return int The satus of the deletion
     */
    public static int delete(int id) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM products WHERE id = ?;");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return status;
    }

    /**
     * Caste an ArrayList of Product into TableModel
     * 
     * @param productList ArrayList  An arrayList of a products
     * 
     * @return TableModel
     */
    public static TableModel toTableModel(ArrayList<Product> productList){
        String col[] = {"Id", "Designation", "Description", "Prix", "Quantité"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for(Product product: productList){
            Object[] obj = {product.getId(), product.getDesignation(), product.getDescription(), product.getPrice(), 0};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

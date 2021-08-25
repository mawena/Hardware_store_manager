package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Product;

/**
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
            System.out.println(e);
        }
        return product;
    }

    /**
     * Return an ArrayList of all products from the database
     * 
     * @return ArrayList<Product> The ArrayList of all products
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
            System.out.println(e);
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
            System.out.println(e);
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
                    "UPDATE products SET id = ?, designation = ?, description = ?, price = ? WHERE id = ?;");
            pS.setInt(1, product.getId());
            pS.setString(2, product.getDesignation());
            pS.setString(3, product.getDescription());
            pS.setDouble(4, product.getPrice());
            pS.setInt(5, product.getId());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
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
            System.out.println(e);
        }
        return status;
    }
}

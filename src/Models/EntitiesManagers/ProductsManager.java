package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Product;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ProductsManager extends Manager {

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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return product;
    }

    public static Product get(String designation) {
        Product product = null;

        try {
            pS = connection.prepareStatement("SELECT * FROM products WHERE designation = ?");
            pS.setString(1, designation);
            result = pS.executeQuery();
            while (result.next()) {
                product = new Product(result.getInt("id"), result.getString("designation"), result.getString("description"), result.getDouble("price"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

        return product;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return productList;
    }

    public static ArrayList<Product> search(String value) {
        ArrayList<Product> productList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE designation LIKE '%" + value + "%';");
            while (result.next()) {
                productList.add(new Product(result.getInt("id"), result.getString("designation"),
                        result.getString("description"), result.getDouble("price")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return productList;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return product;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return product;
    }

    public static boolean delete(int id) {
        try {
            pS = connection.prepareStatement("DELETE FROM products WHERE id = ?;");
            pS.setInt(1, id);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<Product> productList) {
        String col[] = {"Numéro", "Designation", "Description", "Prix"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Product product : productList) {
            Object[] obj = {product.getId(), product.getDesignation(), product.getDescription(), product.getPrice()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

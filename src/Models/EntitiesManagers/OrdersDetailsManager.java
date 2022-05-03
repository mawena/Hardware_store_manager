package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.OrderDetails;
import Models.Entities.Product;
import Models.Entities.Stock;
import Models.EntitiesManagers.StockManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OrdersDetailsManager extends Manager {

    public static OrderDetails get(int idOrder, int idProduct) {
        OrderDetails orderDetails = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM orders_details WHERE id_order = ? AND id_product = ?;");
            pS.setInt(1, idOrder);
            pS.setInt(2, idProduct);
            result = pS.executeQuery();
            while (result.next()) {
                orderDetails = new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetails;
    }

    public static OrderDetails get(int idOrder, int idProduct, String dateEntryProduct) {
        OrderDetails orderDetails = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM orders_details WHERE id_order = ? AND id_product = ? AND date_entry_product = ?;");
            pS.setInt(1, idOrder);
            pS.setInt(2, idProduct);
            pS.setString(3, dateEntryProduct);
            result = pS.executeQuery();
            while (result.next()) {
                orderDetails = new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetails;
    }

    public static ArrayList<OrderDetails> getByOrder(int idOrder) {
        ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        try {
            pS = connection.prepareStatement("SELECT * FROM orders_details WHERE id_order = ?;");
            pS.setInt(1, idOrder);
            result = pS.executeQuery();
            while (result.next()) {
                orderDetailsList.add(new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetailsList;
    }

    public static ArrayList<OrderDetails> getAll() {
        ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM orders_details;");
            while (result.next()) {
                orderDetailsList.add(new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetailsList;
    }

    public static OrderDetails store(OrderDetails orderDetails) {
       try {
            Stock stock = StockManager.getByProduct(orderDetails.getIdProduct()).get(0);
            pS = connection.prepareStatement(
                    "INSERT INTO orders_details(id_order, id_product, date_entry_product, quantity) VALUES(?, ?, ?, ?);");
            pS.setInt(1, orderDetails.getIdOrder());
            pS.setInt(2, orderDetails.getIdProduct());
            pS.setString(3, orderDetails.getDateEntryProduct());
            pS.setInt(4, orderDetails.getQuantity());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetails;
    }

    public static OrderDetails update(int idOrder, int idProduct, OrderDetails orderDetails) {
        try {
            pS = connection.prepareStatement(
                    "UPDATE orders_details SET id_order = ?, id_product = ?, date_entry_product = ?, quantity = ? WHERE id_order = ? AND id_product = ?;");
            pS.setInt(1, orderDetails.getIdOrder());
            pS.setInt(2, orderDetails.getIdProduct());
            pS.setString(3, orderDetails.getDateEntryProduct());
            pS.setInt(4, orderDetails.getQuantity());
            pS.setInt(5, idOrder);
            pS.setInt(6, idProduct);
            pS.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return orderDetails;
    }

    public static boolean delete(int idOrder, int idProduct, String DateEntryProduct) {
        try {
            pS = connection.prepareStatement("DELETE FROM orders_details WHERE id_order = ? AND id_product = ? AND date_entry_product = ?;");
            pS.setInt(1, idOrder);
            pS.setInt(2, idProduct);
            pS.setString(3, DateEntryProduct);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<OrderDetails> orderDetailsList) {
        String col[] = {"Numéro produit", "Produit", "Quantité", "Date Entrée Produit"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (OrderDetails orderDetails : orderDetailsList) {
            Product product = ProductsManager.get(orderDetails.getIdProduct());
            Object[] obj = {product.getId(), product.getDesignation(), orderDetails.getQuantity(), orderDetails.getDateEntryProduct()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

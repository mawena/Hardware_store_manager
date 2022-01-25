package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.OrderDetails;
import Models.Entities.Stock;
import Models.EntitiesManagers.StockManager;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * OrderDetails in the database
 * 
 * @author mawena
 */
public class OrderDetailsManager extends Manager {

    /**
     * Returns a specific OrderDetails of the database
     * 
     * @param idOrder   The idOrder of the OrderDetails
     * @param idProduct The idProduct of the OrderDetails
     * @return OrderDetails
     */
    public static OrderDetails get(int idOrder, int idProduct) {
        OrderDetails orderDetails = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM order_details WHERE id_order = ? AND id_product = ?;");
            pS.setInt(1, idOrder);
            pS.setInt(2, idProduct);
            result = pS.executeQuery();
            while (result.next()) {
                orderDetails = new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetails;
    }

    /**
     * Returns an ArrayList of all OrderDetails of an specific order
     * 
     * @param idOrder The specific order id
     * @return ArrayList
     */
    public static ArrayList<OrderDetails> getByOrder(int idOrder) {
        ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        try {
            pS = connection.prepareStatement("SELECT * FROM order_details WHERE id_order = ?;");
            pS.setInt(1, idOrder);
            result = pS.executeQuery();
            while (result.next()) {
                orderDetailsList.add(new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetailsList;
    }

    /**
     * Return an ArrayList of all OrderDetails in the database
     * 
     * @return ArrayList
     */
    public static ArrayList<OrderDetails> getAll() {
        ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM order_details;");
            while (result.next()) {
                orderDetailsList.add(new OrderDetails(result.getInt("id_order"), result.getInt("id_product"),
                        result.getString("date_entry_product"), result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetailsList;
    }

    /**
     * Insert an OrderDetails into the database
     * 
     * @param orderDetails The OrderDetails that will be inserted
     * @return OrderDetails The OrderDetails that has been inserted
     */
    public static OrderDetails store(OrderDetails orderDetails) {
        try {
            Stock stock = StockManager.getByProduct(orderDetails.getIdProduct()).get(0);
            pS = connection.prepareStatement(
                    "INSERT INTO order_details(id_order, id_product, date_entry_product, quantity) VALUES(?, ?, ?, ?);");
            pS.setInt(1, orderDetails.getIdOrder());
            pS.setInt(2, orderDetails.getIdProduct());
            pS.setString(3, stock.getDateEntryProduct());
            pS.setInt(4, orderDetails.getQuantity());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetails;
    }

    /**
     * Updates an OrderDetails in the database
     * 
     * @param idOrder      The idOrder of the old OrderDetails
     * @param idProduct    The idProduct of the old OrderDetails
     * @param orderDetails The new OrderDetails
     * @return OrderDetails The new OrderDetails
     */
    public static OrderDetails update(int idOrder, int idProduct, OrderDetails orderDetails) {
        try {
            pS = connection.prepareStatement(
                    "UPDATE order_details SET id_order = ?, id_product = ?, date_entry_product = ?, quantity = ? WHERE id_order = ? AND id_product = ?;");
            pS.setInt(1, orderDetails.getIdOrder());
            pS.setInt(2, orderDetails.getIdProduct());
            pS.setString(3, orderDetails.getDateEntryProduct());
            pS.setInt(4, orderDetails.getQuantity());
            pS.setInt(5, idOrder);
            pS.setInt(6, idProduct);
            pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetails;
    }

    /**
     * Deletes an OrderDetails from the database
     * 
     * @param idOrder   The idOrder of the OrderDetails
     * @param idProduct The idProduct of the OrderDetails
     * @return int The status of the deletion
     */
    public static int delete(int idOrder, int idProduct) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM order_details WHERE id_order = ? AND id_product = ?;");
            pS.setInt(1, idOrder);
            pS.setInt(2, idProduct);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
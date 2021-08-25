package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Order;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * order in the database
 * 
 * @author mawena
 */
public class OrderManager extends Manager {

    /**
     * Returns a specific Order
     * 
     * @param id The id of the order
     * @return Order The Order found
     */
    public static Order get(int id) {
        Order order = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM orders WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                order = new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    /**
     * Returns a ArrayList of all Order in the database
     * 
     * @return ArrayList<Order>
     */
    public static ArrayList<Order> getAll() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM orders;");
            while (result.next()) {
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }

    /**
     * Insert a Order into the database
     * 
     * @param order The Order that will be inserted
     * @return Order The Order that has been inserted
     */
    public static Order store(Order order) {
        try {
            pS = connection.prepareStatement("INSERT INTO orders(id_client, id_employer, date_order) VALUES(?, ?, NOW());");
            pS.setInt(1, order.getIdClient());
            pS.setInt(2, order.getIdEmployer());
            pS.executeUpdate();
            closeQuery();
            order.setId(getLastId("orders"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    /**
     * Updates a Order in the database
     * 
     * @param id    The id of old Order
     * @param order The new Order
     * @return Order The new Order
     */
    public static Order update(int id, Order order) {
        try {
            pS = connection.prepareStatement("UPDATE orders SET id = ?, id_client = ?, id_employer = ?, date_order = ? WHERE id = ?;");
            pS.setInt(1, order.getId());
            pS.setInt(2, order.getIdClient());
            pS.setInt(3, order.getIdEmployer());
            pS.setString(4, order.getDateOrder());
            pS.setInt(5, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    /**
     * Deletes a Order from the database
     * 
     * @param id The id of the Order that will be deleted
     * @return int The satus of the deletion
     */
    public static int delete(int id) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM orders WHERE id = ?");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
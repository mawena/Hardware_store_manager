package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Order;
import javax.swing.JOptionPane;

public class OrdersManager extends Manager {

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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return order;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static Order store(Order order) {
        try {
            pS = connection.prepareStatement("INSERT INTO orders(id_client, id_employer, date_order) VALUES(?, ?, NOW());");
            pS.setInt(1, order.getIdClient());
            pS.setInt(2, order.getIdEmployer());
            pS.executeUpdate();
            closeQuery();
            order.setId(getLastId("orders"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return order;
    }

    public static Order update(int id, Order order) {
        try {
            pS = connection.prepareStatement("UPDATE orders SET id = ?, id_client = ?, id_employer = ?, date_order = ? WHERE id = ?;");
            pS.setInt(1, order.getId());
            pS.setInt(2, order.getIdClient());
            pS.setInt(3, order.getIdEmployer());
            pS.setString(4, order.getDateOrder());
            pS.setInt(5, id);
            pS.executeUpdate();
            order.setId(getLastId("orders"));
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return order;
    }

    public static boolean delete(int id) {
        try {
            pS = connection.prepareStatement("DELETE FROM orders WHERE id = ?");
            pS.setInt(1, id);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}

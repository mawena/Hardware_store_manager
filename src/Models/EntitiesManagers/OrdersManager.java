package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Order;
import Models.Entities.OrderDetails;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OrdersManager extends Manager {

    public static Order get(int id) {
        Order order = null;
        try {
            pS = connection.prepareStatement("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE orders.id = ? and clients.id = orders.id_client and employers.id = orders.id_employer;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                order = new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return order;
    }

    public static Order get(int idClient, int idEmployer, String DateCommand) {
        Order order = null;
        try {
            pS = connection.prepareStatement("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE orders.id_client = ? and orders.id_employer = ? and orders.date_order = ? and clients.id = orders.id_client and employers.id = orders.id_employer;");
            pS.setInt(1, idClient);
            pS.setInt(2, idEmployer);
            pS.setString(3, DateCommand);
            result = pS.executeQuery();
            while (result.next()) {
                order = new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name"));
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
            result = statement.executeQuery("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE clients.id = orders.id_client and employers.id = orders.id_employer ORDER BY date_order;");
            while (result.next()) {
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static ArrayList<Order> getByClient(int clientId) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE orders.id_client = " + clientId + " and clients.id = orders.id_client and employers.id = orders.id_employer;");
            while (result.next()) {
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static ArrayList<Order> getByEmployer(int employerId) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE orders.id_employer = " + employerId + " and clients.id = orders.id_client and employers.id = orders.id_employer;");
            while (result.next()) {
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static ArrayList<Order> getByClientEmployer(int clientId, int employerId) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT orders.*, CONCAT(employers.last_name, ' ', employers.first_name) as employer_name, CONCAT(clients.last_name, ' ', clients.first_name) as client_name FROM orders, clients, employers WHERE orders.id_client = " + clientId + " AND orders.id_employer = " + employerId + " and clients.id = orders.id_client and employers.id = orders.id_employer;");
            while (result.next()) {
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"), result.getString("date_order"), result.getString("employer_name"), result.getString("client_name")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return orderList;
    }

    public static Order store(Order order) {
        try {
            pS = connection.prepareStatement("INSERT INTO orders(id_client, id_employer, date_order) VALUES(?, ?, ?);");
            pS.setInt(1, order.getIdClient());
            pS.setInt(2, order.getIdEmployer());
            pS.setString(3, order.getDateOrder());
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
            pS = connection.prepareStatement("UPDATE orders SET id_client = ?, id_employer = ?, date_order = ? WHERE id = ?;");
            pS.setInt(1, order.getIdClient());
            pS.setInt(2, order.getIdEmployer());
            pS.setString(3, order.getDateOrder());
            pS.setInt(4, id);
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

    public static TableModel toTableModel(ArrayList<Order> orderList) {
        String col[] = {"commande", "Client", "Employé", "Date", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (Order order : orderList) {
            double total = 0;
            for (OrderDetails orderDetail : OrdersDetailsManager.getByOrder(order.getId())) {
                total = total + orderDetail.getQuantity();
            }
            //Object[] obj = {order.getId(), order.getIdClient(), order.getClientName(), order.getIdEmployer(), order.getEmployerName(), order.getDateOrder(), total};
            Object[] obj = {order.getId(), order.getClientName(),order.getEmployerName(),  order.getDateOrder(), total};

            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

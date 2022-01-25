package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Client;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ClientManager extends Manager {

    public static Client get(int id) {
        Client client = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                client = new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                        result.getString("first_name"), result.getString("category"), result.getString("tel"), result.getString("sex"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return client;
    }

    public static ArrayList<Client> getAll() {
        ArrayList<Client> clientList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM clients;");
            while (result.next()) {
                clientList
                        .add(new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                                result.getString("first_name"), result.getString("category"), result.getString("tel"), result.getString("sex")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return clientList;
    }

    public static ArrayList<Client> search(String col, String value) {
        ArrayList<Client> clientList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM clients WHERE " + col + " LIKE '%" + value + "%';");
            while (result.next()) {
                clientList.add(new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                        result.getString("first_name"), result.getString("category"), result.getString("tel"), result.getString("sex")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return clientList;
    }

    public static Client store(Client client) {
        try {
            pS = connection.prepareStatement(
                    "INSERT INTO clients(num_CIN, last_name, first_name, category, tel, sex) VALUES(?, ?, ?, ?, ?, ?);");
            pS.setString(1, client.getNumCIN());
            pS.setString(2, client.getLastName());
            pS.setString(3, client.getFirstName());
            pS.setString(4, client.getCategory());
            pS.setString(5, client.getTel());
            pS.setString(6, client.getSex());
            pS.executeUpdate();
            client.setId(getLastId("clients"));
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return client;
    }

    public static Client update(int id, Client client) {
        try {
            pS = connection.prepareStatement(
                    "UPDATE clients SET id = ?, num_CIN = ?, last_name = ?, first_name = ?, category = ?, tel = ?, sex = ? WHERE id = ?;");
            pS.setInt(1, client.getId());
            pS.setString(2, client.getNumCIN());
            pS.setString(3, client.getLastName());
            pS.setString(4, client.getFirstName());
            pS.setString(5, client.getCategory());
            pS.setString(6, client.getTel());
            pS.setString(7, client.getSex());
            pS.setInt(8, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return client;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return status;
    }

    public static TableModel toTableModel(ArrayList<Client> clientList) {
        String col[] = {"Id", "CNI", "Nom", "Prénom", "Tel", "Catégorie", "Sexe"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Client client : clientList) {
            Object[] obj = {client.getId(), client.getNumCIN(), client.getLastName(), client.getFirstName(), client.getTel(), client.getCategory(), client.getSex()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

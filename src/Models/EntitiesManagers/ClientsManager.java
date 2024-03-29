package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Client;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ClientsManager extends Manager {

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

    public static Client get(String clientCIN) {
        Client client = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM clients WHERE num_CIN = ?;");
            pS.setString(1, clientCIN);
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
    
    public static Client getByName(String clientName){
        Client client = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM clients WHERE CONCAT(last_name, ' ', first_name) = ?;");
            pS.setString(1, clientName);
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

    public static ArrayList<Client> search(String value) {
        ArrayList<Client> clientList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM clients WHERE last_name LIKE '%" + value + "%' OR first_name LIKE '%" + value + "%';");
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
            pS = connection.prepareStatement("UPDATE clients SET num_CIN = ?, last_name = ?, first_name = ?, category = ?, tel = ?, sex = ? WHERE id = ?;");
            pS.setString(1, client.getNumCIN());
            pS.setString(2, client.getLastName());
            pS.setString(3, client.getFirstName());
            pS.setString(4, client.getCategory());
            pS.setString(5, client.getTel());
            pS.setString(6, client.getSex());
            pS.setInt(7, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return client;
    }

    public static boolean delete(int id) {
        try {
            pS = connection.prepareStatement("DELETE FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<Client> clientList) {
        String col[] = {"Numéro client", "CNI", "Nom", "Prénom", "Tel", "Catégorie", "Sexe"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Client client : clientList) {
            Object[] obj = {client.getId(), client.getNumCIN(), client.getLastName(), client.getFirstName(), client.getTel(), client.getCategory(), client.getSex()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

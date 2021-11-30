package Model.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Model.entities.Client;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


/**
 * Contains static methods for selection, inserting, updating, and removing
 * client in the database
 * 
 * @author mawena
 */
public class ClientManager extends Manager {

    /**
     * Return a Client from the database
     * 
     * @param id The client id
     * @return Client
     */
    public static Client get(int id) {
        Client client = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                client = new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                        result.getString("first_name"), result.getString("category"), result.getString("tel"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return client;
    }

    /**
     * Return an ArrayList of all Client from the database
     * 
     * @return ArrayList<Client>
     */
    public static ArrayList<Client> getAll() {
        ArrayList<Client> clientList = new ArrayList<Client>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM clients;");
            while (result.next()) {
                clientList
                        .add(new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                                result.getString("first_name"), result.getString("category"), result.getString("tel")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return clientList;
    }

    /**
     * Search a clients
     * 
     * @return ArrayList<Client>
     */
    public static ArrayList<Client> search(String col, String value) {
        ArrayList<Client> clientList = new ArrayList<Client>();
        try {
            pS = connection.prepareStatement("SELECT * FROM clients where ? like ?;");
            pS.setString(1, col);
            pS.setString(2, value);
            result = pS.executeQuery();
            while (result.next()) {
                clientList.add(new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"),
                result.getString("first_name"), result.getString("category"), result.getString("tel")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return clientList;
    }

    /**
     * Insert a Client into the database
     * 
     * @param client The Client that will be inserted
     * @return Client The Client that has been inserted
     */
    public static Client store(Client client) {
        try {
            pS = connection.prepareStatement(
                    "INSERT INTO clients(num_CIN, last_name, first_name, category, tel) VALUES(?, ?, ?, ?, ?);");
            pS.setString(1, client.getNumCIN());
            pS.setString(2, client.getLastName());
            pS.setString(3, client.getFirstName());
            pS.setString(4, client.getCategory());
            pS.setString(5, client.getTel());
            pS.executeUpdate();
            client.setId(getLastId("clients"));
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return client;
    }

    /**
     * Updates a Client in the database
     * 
     * @param   id       The Client that will be updated id's
     * @param   Client   The Client that will be updated
     * @return  Client   The Client that has been updated
     */
    public static Client update(int id, Client client) {
        try {
            pS = connection.prepareStatement(
                    "UPDATE clients SET id = ?, num_CIN = ?, last_name = ?, first_name = ?, category = ?, tel = ? WHERE id = ?;");
            pS.setInt(1, client.getId());
            pS.setString(2, client.getNumCIN());
            pS.setString(3, client.getLastName());
            pS.setString(4, client.getFirstName());
            pS.setString(5, client.getCategory());
            pS.setString(6, client.getTel());
            pS.setInt(7, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return client;
    }

    /**
     * Deletes a customer from the database
     * 
     * @param id Integer
     * @return Integer
     */
    public static int delete(int id) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return status;
    }

    /**
     * Caste an ArrayList of Client into TableModel
     * 
     * @param clientList ArrayList<Client>  An arrayList of a client
     * 
     * @return TableModel
     */
    public static TableModel toTableModel(ArrayList<Client> clientList){
        String col[] = {"Id", "CNI", "Nom", "Prénom", "Tel", "Catégorie"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for(Client client: clientList){
            Object[] obj = {client.getId(), client.getNumCIN(), client.getLastName(), client.getFirstName(), client.getTel(), client.getCategory()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}
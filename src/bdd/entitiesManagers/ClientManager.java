package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Client;

/**
 * @author mawena
 */
public class ClientManager extends Manager{
    
    
    /** 
     * Return a Client from the database
     * @param id    The client id
     * @return Client
     */
    public static Client get(int id){
        Client client = null;
        try{
            pS = connection.prepareStatement("SELECT * FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while(result.next()){
                client = new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"), result.getString("first_name"), result.getString("category"), result.getString("tel"));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return client;
    }

    
    /** 
     * Return an ArrayList of all Client from the database
     * @return ArrayList<Client>
     */
    public static ArrayList<Client> getAll(){
        ArrayList<Client> clientList = new ArrayList<Client>();
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM clients;");
            while(result.next()){
                clientList.add(new Client(result.getInt("id"), result.getString("num_CIN"), result.getString("last_name"), result.getString("first_name"), result.getString("category"), result.getString("tel")));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return clientList;
    }

    
    /** 
     * Insert a Client into the database
     * @param client    The Client that will be inserted
     * @return Client   The Client that has been inserted
     */
    public static Client store(Client client){
        try{
            pS = connection.prepareStatement("INSERT INTO clients(num_CIN, last_name, first_name, category, tel) VALUES(?, ?, ?, ?, ?);");
            pS.setString(1, client.getNumCIN());
            pS.setString(2, client.getLastName());
            pS.setString(3, client.getFirstName());
            pS.setString(4, client.getCategory());
            pS.setString(5, client.getTel());
            pS.executeUpdate();
            client.setId(getLastId("clients"));
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return client;
    }

    
    /** 
     * Updates a Client in the database
     * @param client    The Client that will be updated
     * @return Client   The Client that has been updated
     */
    public static Client update(Client client){
        try{
            pS = connection.prepareStatement("UPDATE clients SET id = ?, num_CIN = ?, last_name = ?, first_name = ?, category = ?, tel = ? WHERE id = ?;");
            pS.setInt(1, client.getId());
            pS.setString(2, client.getNumCIN());
            pS.setString(3, client.getLastName());
            pS.setString(4, client.getFirstName());
            pS.setString(5, client.getCategory());
            pS.setString(6, client.getTel());
            pS.setInt(7, client.getId());
            pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return client;
    }

    
    /** 
     * Deletes a customer from the database
     * @param id
     * @return int
     */
    public static int delete (int id){
        int status = 0;
        try{
            pS = connection.prepareStatement("DELETE FROM clients WHERE id = ?;");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){ 
            System.out.println(e);
        }
        return status;
    }
}

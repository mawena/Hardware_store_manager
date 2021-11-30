package Controller;

import java.util.ArrayList;
import Model.entities.Client;
import Model.entitiesManagers.ClientManager;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ClientController {

    /**
     * Verify if the client is valid
     * 
     * @param client Client
     * 
     * @return boolean
     */
    public static boolean isValid(Client client) {
        boolean rep = true;
        if (client.getNumCIN().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le numéro de carte d'identié est manquant!");
        } else if (client.getLastName().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
        } else if (client.getFirstName().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le prénom est manquant!");
        } else if (client.getTel().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le numéro de téléphone est manquant!");
        }
        return rep;
    }

    /**
     * Insert a client into the database
     * 
     * @param client Client
     * 
     * @return void
     */
    public static void store(Client client) {
        Client cl = ClientManager.get(client.getId());
        if (cl == null) {
            if (isValid(client)) {
                client.store();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le client existe déjà!");
        }
    }

    /**
     * Update a Client
     * 
     * @param clientId int The client will be updated id's
     * @param client   Client The new client
     * 
     * @return void
     */
    public static void update(int clientId, Client client) {
        Client cl = ClientManager.get(clientId);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "Le client n'existe pas!");
        } else {
            if (isValid(client)) {
                ClientManager.update(clientId, client);
            }
        }
    }

    /**
     * Deletes a client from the database
     * 
     * @param clientId int The client id's
     * 
     * @return void
     */
    public static void destroy(int clientId) {
        Client client = ClientManager.get(clientId);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Le client sélectioné n'existe pas!");
        } else {
            ClientManager.delete(clientId);
        }
    }
}

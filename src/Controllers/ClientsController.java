package Controllers;

import Models.Entities.Client;
import Models.EntitiesManagers.ClientManager;
import javax.swing.JOptionPane;

public class ClientsController {

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
     * @return boolean
     */
    public static boolean store(Client client) {
        Client cl = ClientManager.get(client.getId());
        if (cl == null) {
            if (isValid(client)) {
                return (ClientManager.store(client) != null);
            }else{
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le client existe déjà!");
            return false;
        }
    }

    /**
     * Update a Client
     * 
     * @param clientId Integer   The client will be updated id's
     * @param client   Client The new client
     * 
     * @return boolean
     */
    public static boolean update(int clientId, Client client) {
        Client cl = ClientManager.get(clientId);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "Le client n'existe pas!");
            return false;
        } else {
            if (isValid(client)) {
                return (ClientManager.update(clientId, client) != null);
            }else{
                return false;
            }
        }
    }

    /**
     * Deletes a client from the database
     * 
     * @param clientId Integer The client id's
     * 
     * @return boolean
     */
    public static boolean destroy(int clientId) {
        Client client = ClientManager.get(clientId);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Le client sélectioné n'existe pas!");
            return false;
        } else {
            return (ClientManager.delete(clientId) != 0);
        }
    }
}

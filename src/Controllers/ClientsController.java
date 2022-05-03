package Controllers;

import Models.Entities.Client;
import Models.EntitiesManagers.ClientsManager;
import javax.swing.JOptionPane;

public class ClientsController {

    public static boolean isValid(Client client) {
        if (client.getNumCIN().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le numéro de carte d'identié est manquant!");
            return false;
        } else if (client.getLastName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
            return false;
        } else if (client.getFirstName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le prénom est manquant!");
            return false;
        } else if (client.getTel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le numéro de téléphone est manquant!");
            return false;
        }
        return true;
    }

    public static boolean store(Client client) {
        Client cl = ClientsManager.get(client.getNumCIN());
        if (cl == null) {
            if (isValid(client)) {
                return (ClientsManager.store(client) != null);
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le client existe déjà!");
            return false;
        }
    }

    public static boolean update(int clientId, Client client) {
        Client cl = ClientsManager.get(clientId);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "Le client n'existe pas!");
            return false;
        } else {
            if (isValid(client)) {
                return (ClientsManager.update(clientId, client) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int clientId) {
        Client client = ClientsManager.get(clientId);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Le client sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le client?") == 0) {
                return (ClientsManager.delete(clientId));
            } else {
                return false;
            }
        }
    }
}

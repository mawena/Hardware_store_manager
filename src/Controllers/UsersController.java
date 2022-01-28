package Controllers;

import Models.Entities.User;
import Models.EntitiesManagers.UsersManager;
import javax.swing.JOptionPane;

public class UsersController {

    public static boolean isValid(User user) {
        boolean rep = true;
        if (user.getUsername().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le nom d'utilisateur est manquant!");
        } else if (user.getPassword().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le mot de passe est manquant!");
        } else if (user.getType().isEmpty()) {
            rep = false;
            JOptionPane.showMessageDialog(null, "Le type est manquant!");
        }
        return rep;
    }

    public static boolean login(String username, String password, String type) {
        User user = new User(username, password, type);
        if (isValid(user)) {
            User userDB = UsersManager.get(user.getUsername());
            if (userDB == null) {
                JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
                return false;
            } else {
                if (user.getPassword().equals(userDB.getPassword())) {
                    if (user.getType().equals(userDB.getType())) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Le type est incorrect.");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Le mot de passe est incorect.");
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static boolean store(User user) {
        User us = UsersManager.get(user.getUsername());
        if (us == null) {
            return UsersManager.store(user) != null;
        } else {
            JOptionPane.showMessageDialog(null, "L'utilisateur existe déjà.");
            return false;
        }
    }

    public static boolean update(int id, User user) {
        User us = UsersManager.get(id);
        if (us == null) {
            JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
            return false;
        } else {
            return (UsersManager.update(id, user) != null);
        }
    }

    public static boolean destroy(int id) {
        User us = UsersManager.get(id);
        if (us == null) {
            JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le client?") == 0) {
                return UsersManager.delete(id);
            }
            return false;
        }
    }
}

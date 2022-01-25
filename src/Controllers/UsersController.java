/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Entities.User;
import Models.EntitiesManagers.UserManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mawena
 */
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
            User userDB = UserManager.get(user.getUsername());
            if (userDB == null) {
                JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
                return false;
            } else {
                if (user.getPassword() == null ? userDB.getPassword() == null : user.getPassword().equals(userDB.getPassword())) {
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

    /**
     * Insert a user into the database
     *
     * @param user User The user will be inserted
     * @return boolean
     */
    public static boolean store(User user) {
        User us = UserManager.get(user.getUsername());
        if (us == null) {
            return UserManager.store(user) != null;
        } else {
            JOptionPane.showMessageDialog(null, "L'utilisateur existe déjà.");
            return false;
        }
    }

    public static boolean update(int id, User user) {
        User us = UserManager.get(id);
        if (us == null) {
            JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
            return false;
        } else {
            return (UserManager.update(id, user) != null);
        }
    }

    public static boolean destroy(int id) {
        User us = UserManager.get(id);
        if (us == null) {
            JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas.");
            return false;
        } else {
            return UserManager.delete(id) != 0;
        }
    }
}

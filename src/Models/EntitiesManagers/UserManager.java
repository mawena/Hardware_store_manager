package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.User;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Contains static methods for selection, inserting, updating, and removing user
 * in the database
 *
 * @author mawena
 */
public class UserManager extends Manager {

    /**
     * Select User using id
     *
     * @param id
     * @return
     */
    public static User get(int id) {
        User user = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM users WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                user = new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("type"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return user;
    }

    /**
     * Return a user from the database
     *
     * @param username The username of the user that we will to find
     * @return User The username found
     */
    public static User get(String username) {
        User user = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM users WHERE username = ?;");
            pS.setString(1, username);
            result = pS.executeQuery();
            while (result.next()) {
                user = new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("type"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return user;
    }

    /**
     * Search a user
     *
     * @param col String
     * @param value String
     * @return ArrayList
     */
    public static ArrayList<User> search(String col, String value) {
        ArrayList<User> userList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM users WHERE " + col + " LIKE '%" + value + "%'");
            while (result.next()) {
                userList.add(new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("type")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return userList;
    }

    /**
     * Return an ArrayList of all user of in the database
     *
     * @return ArrayList The array of all user of the database
     */
    public static ArrayList<User> getAll() {
        ArrayList<User> userList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM users");
            while (result.next()) {
                userList.add(new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("type")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return userList;
    }

    /**
     * Insert a user into the database
     *
     * @param user User The user that will be inserted
     * @return User The user that has been inserted
     */
    public static User store(User user) {
        try {
            pS = connection.prepareStatement("INSERT INTO users(username, password, type) VALUES(?, ?, ?);");
            pS.setString(1, user.getUsername());
            pS.setString(2, user.getPassword());
            pS.setString(3, user.getType());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return user;
    }

    /**
     * Updates a user in the database
     *
     * @param id Integer The id of the user that will be updated
     * @param user User The new user
     * @return User
     */
    public static User update(int id, User user) {
        try {
            pS = connection.prepareStatement("UPDATE users SET username = ?, password = ?, type = ? WHERE id = ?;");
            pS.setString(1, user.getUsername());
            pS.setString(2, user.getPassword());
            pS.setString(3, user.getType());
            pS.setInt(4, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
        return user;
    }

    /**
     * Deletes a user in the database
     *
     * @param id Integer The id of the user into the database
     * @return Integer The status of the deletion
     */
    public static int delete(int id) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM users WHERE id = ?;");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return status;
    }

    /**
     * Caste an ArrayList of User into TableModel
     *
     * @param userList ArrayList An arrayList of a user
     *
     * @return TableModel
     */
    public static TableModel toTableModel(ArrayList<User> userList) {
        String col[] = {"Numéro", "Nom d'utilisateur", "Mot de passe", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (User user : userList) {
            Object[] obj = {user.getId(), user.getUsername(), hash(user.getPassword()), user.getType()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }

    /**
     * Return hash
     *
     * @param password String
     * @return String
     */
    public static String hash(String password) {
        String chain = "";
        for (int i = 0; i < password.length(); i++) {
            chain += "*";
        }
        return chain;
    }
}

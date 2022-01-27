package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.User;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UsersManager extends Manager {

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

    public static ArrayList<User> search(String value) {
        ArrayList<User> userList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM users WHERE username LIKE '%" + value + "%'");
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

    public static boolean delete(int id) {
        try {
            pS = connection.prepareStatement("DELETE FROM users WHERE id = ?;");
            pS.setInt(1, id);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<User> userList) {
        String col[] = {"Numéro", "Nom d'utilisateur", "Mot de passe", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (User user : userList) {
            Object[] obj = {user.getId(), user.getUsername(), hash(user.getPassword()), user.getType()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }

    public static String hash(String password) {
        String chain = "";
        for (int i = 0; i < password.length(); i++) {
            chain += "*";
        }
        return chain;
    }
}

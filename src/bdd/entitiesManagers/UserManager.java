package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.User;

/**
 * @author mawena
 */
public class UserManager extends Manager{
    /**
     * Return a user from the database
     * @param username The username of the user that we will to find
     * @return User Ther username finded
     */
    public static User get(String username){
        User user = null;
        try{
            pS = connection.prepareStatement("SELECT * FROM users WHERE username = ?;");
            pS.setString(1, username);
            result = pS.executeQuery();
            while(result.next()){
                user = new User(result.getString("username"), result.getString("password"));
            }
            closeQuery();            
        }catch(SQLException e){
            System.out.println(e);
        }
        return user;
    }

    /**
     * Return an ArrayList of all user of in the database
     * @return ArrayList<User> The array of all user of the database
     */
    public static ArrayList<User> getAll(){
        ArrayList<User> userList = new ArrayList<User>();
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM users;");
            while(result.next()){
                userList.add(new User(result.getString("username"), result.getString("password")));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return userList;
    }

    /**
     * Insert a user into the database
     * @param User user The user that will be inserted
     * @return User The user that has been inserted
     */
    public static User store(User user){
        try{
            pS = connection.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?);");
            pS.setString(1, user.getUsername());
            pS.setString(2, user.getPassword());
            pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return user;
    }

    
    /** 
     * Updates a user in the database
     * @param username The username of the user that will be updated
     * @param user The new user
     * @return User
     */
    public static User update(String username, User user){
        try{
            pS = connection.prepareStatement("UPDATE users SET username = ?, password = ? WHERE username = ?;");
            pS.setString(1, user.getUsername());
            pS.setString(2, user.getPassword());
            pS.setString(3, username);
            pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return user;
    }

    
    /** 
     * Deletes a user in the database
     * @param username The username of the user into the database
     * @return int The status of the deletion
     */
    public static int delete (String username){
        int status = 0;
        try{
            pS = connection.prepareStatement("DELETE FROM users WHERE username = ?;");
            pS.setString(1, username);
            status = pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){ 
            System.out.println(e);
        }
        return status;
    }
}

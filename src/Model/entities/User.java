package Model.entities;

import Model.entitiesManagers.UserManager;

/**
 * Represents the table "users" of the database as an application entity
 * 
 * @author mawena
 */
public class User {
    /**
     * The username of the user
     */
    private String username;

    /**
     * The password of the user
     */
    private String password;

    /**
     * A User object represent the table user into the database
     * @param username The username of the user
     * @param password The username's password
     */
    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    
    /** 
     * Return the user's username
     * @return String The user's username
     */
    public String getUsername() {
        return this.username;
    }

    
    /** 
     * Modify the user's username
     * @param username The new user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * Return the user's password
     * @return String The user's password
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * Modify the user's password
     * @param password The new user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * Display correctly the user
     * @return String The String of the user's diplay
     */
    public String toString(){
        return "{\n\tusername => \"" + this.username + "\",\n\tpassword => \"" + this.password + "\"\n}";
    }

    /**
     * Store this user into the database
     */
    public void store(){
        UserManager.store(this);
    }

    /**
     * Update this user into the database
     * @param   User    user
     */
    public void update(User user){
        UserManager.update(this.getUsername(), user);
    }

    
    /** 
     * Delete this user from the database
     * @return int
     */
    public int delete(){
        return UserManager.delete(this.username);
    }
}

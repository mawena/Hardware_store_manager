package Models.Entities;

import Models.EntitiesManagers.UserManager;

/**
 * Represents the table "users" of the database as an application entity
 *
 * @author mawena
 */
public class User {

    /**
     * The username of the user
     */
    private int id;

    /**
     * The username of the user
     */
    private String username;

    /**
     * The password of the user
     */
    private String password;

    private String type;

    /**
     * A User object represent the table user into the database
     *
     * @param id
     * @param username The username of the user
     * @param password The username's password
     * @param type The username's type
     */
    public User(int id, String username, String password, String type) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setType(type);
    }

    /**
     * A User object represent the table user into the database
     *
     * @param username The username of the user
     * @param password The username's password
     * @param type
     */
    public User(String username, String password, String type) {
        this.setUsername(username);
        this.setPassword(password);
        this.setType(type);
    }

    /**
     * Return the user's id
     *
     * @return String The user's username
     */
    public int getId() {
        return this.id;
    }

    /**
     * Modify the user's id
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the user's username
     *
     * @return String The user's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Modify the user's username
     *
     * @param username The new user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return the user's password
     *
     * @return String The user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Modify the user's password
     *
     * @param password The new user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Display correctly the user
     *
     * @return String The String of the user's display
     */
    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tusername => \"" + this.username + "\",\n\tpassword => \"" + this.password + "\"\n}";
    }

    /**
     * Store this user into the database
     */
    public void store() {
        UserManager.store(this);
    }

    /**
     * Update this user into the database
     *
     * @param User user
     */
    public void update(User user) {
        UserManager.update(this.getId(), user);
    }

    /**
     * Delete this user from the database
     *
     * @return Integer
     */
    public int delete() {
        return UserManager.delete(this.id);
    }
}

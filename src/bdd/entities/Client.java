package bdd.entities;

import bdd.entitiesManagers.ClientManager;

/**
 * @author mawena
 */
public class Client {

    /**
     * The identifiant of the Client
     */
    private int id;

    /**
     * The number of the identity card of the Client
     */
    private String numCIN;

    /**
     * The last name of the Client
     */
    private String lastName;

    /**
     * The first name of the Client
     */
    private String firstName;

    /**
     * The category of the Client;
     */
    private String category;

    /**
     * The telephone number of the Client
     */
    private String tel;

    /**
     * A Client object represent the table clients from the database
     * @param id
     * @param numCIN
     * @param lastName
     * @param firstName
     * @param category
     * @param tel
     */
    public Client(int id, String numCIN, String lastName, String firstName, String category, String tel) {
        this.setId(id);
        this.setNumCIN(numCIN);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setCategory(category);
        this.setTel(tel);
    }
    
    /**
     * A Client object represent the table clients from the database
     * @param numCIN
     * @param lastName
     * @param firstName
     * @param category
     * @param tel
     */
    public Client(String numCIN, String lastName, String firstName, String category, String tel) {
        this.setNumCIN(numCIN);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setCategory(category);
        this.setTel(tel);
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getNumCIN() {
        return this.numCIN;
    }

    
    /** 
     * @param numCIN
     */
    public void setNumCIN(String numCIN) {
        this.numCIN = numCIN;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /** 
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * @return String
     */
    public String getCategory() {
        return this.category;
    }

    
    /** 
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    
    /** 
     * @return String
     */
    public String getTel() {
        return this.tel;
    }

    
    /** 
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "{\n\tid => \"" + this.id + "\",\n\tnumCIN => \"" + this.numCIN + "\",\n\tlastName  => \"" + this.lastName + "\",\n\tfirstName  => \"" + this.firstName + "\",\n\tcategory  => \"" + this.category + ",\n\ttel  => \"" + this.tel + "\"\n}";
    }


    /**
     * Insert the Client into the databas
     */
    public void store(){
        ClientManager.store(this);
    }
    
    /**
     * Updates the Client in the database
     */
    public void update(){
        ClientManager.update(this);
    }
    
    
    /** 
     * Deletes the Client from the database
     * @return int
     */
    public int delete(){
        return ClientManager.delete(this.id);
    }
}

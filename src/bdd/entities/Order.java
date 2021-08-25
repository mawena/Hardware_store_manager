package bdd.entities;

import bdd.entitiesManagers.OrderManager;

/**
 * Represents the table "orders" of the database as an application entity
 * 
 * @author mawena
 */
public class Order {
    private int id;
    private int idClient;
    private int idEmployer;

    public Order(int id, int idClient, int idEmployer){
        this.setId(id);
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
    }

    public Order(int idClient, int idEmployer){
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @param idClient
     */
    public void setId(int idClient) {
        this.idClient = idClient;
    }

    
    /** 
     * @return int
     */
    public int getIdClient() {
        return this.idClient;
    }

    
    /** 
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    
    /** 
     * @return int
     */
    public int getIdEmployer() {
        return this.idEmployer;
    }

    
    /** 
     * @param idEmployer
     */
    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "{\n\tid => \"" + this.id + "\",\n\tidClient => \"" + this.idClient + "\",\n\tidEmployer  => \"" + this.idEmployer + "\"\n}";
    }

    public void store(){
        OrderManager.store(this);
    }

    public void update(){
        OrderManager.update(this);
    }

    public int delete(){
        return OrderManager.delete(this.id);
    }
}

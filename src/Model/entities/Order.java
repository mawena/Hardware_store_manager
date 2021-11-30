package Model.entities;

import Model.entitiesManagers.OrderManager;

/**
 * Represents the table "orders" of the database as an application entity
 * 
 * @author mawena
 */
public class Order {

    /**
     * The identifiant of the Order in the database
     */
    private int id;

    /**
     * The identifiant of the Client in the database
     */
    private int idClient;

    /**
     * The identifiant of the Emploer in the database
     */
    private int idEmployer;

    /**
     * The date of the order
     */
    private String dateOrder;

    /**
     * A Order object represent the table "order" from the database
     * 
     * @param id         The id of the Order
     * @param idClient   The id of the Client
     * @param idEmployer The id of the Employer
     * @param dateOrder  The date of the Order
     */
    public Order(int id, int idClient, int idEmployer, String dateOrder) {
        this.setId(id);
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
        this.setDateOrder(dateOrder);
    }
    
    /**
     * A Order object represent the table "order" from the database
     * 
     * @param idClient   The id of the Client
     * @param idEmployer The id of the Employer
     * @param dateOrder  The date of the Order
     */
    public Order(int idClient, int idEmployer, String dateOrder) {
        this.setIdClient(idClient);
        this.setIdEmployer(idEmployer);
        this.setDateOrder(dateOrder);
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
    public void setId(int id) {
        this.id = id;
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
    public String getDateOrder() {
        return this.dateOrder;
    }

    /**
     * @param dateOrder
     */
    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * @return String
     */
    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tidClient => \"" + this.idClient + "\",\n\tidEmployer  => \""
                + this.idEmployer + "\",\n\tdateOrder  => \"" + this.dateOrder + "\"\n}";
    }

    /**
     * Insert the Order into the database
     */
    public void store() {
        Order tmp = OrderManager.store(this);
        this.setId(tmp.getId());
    }

    /**
     * Updates the Order in the database
     * 
     * @param Order order
     */
    public void update(Order order) {
        OrderManager.update(this.getId(), order);
    }

    /**
     * Deletes the Order from the database
     * 
     * @return int The satus of the deletion
     */
    public int delete() {
        return OrderManager.delete(this.id);
    }
}

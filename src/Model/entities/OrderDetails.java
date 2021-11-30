package Model.entities;

import Model.entitiesManagers.OrderDetailsManager;

/**
 * Represents the table "orders_details" of the database as an application
 * entity
 * 
 * @author mawena
 */
public class OrderDetails {

    /**
     * The id of the order ordered
     */
    private int idOrder;

    /**
     * The id of the product ordered
     */
    private int idProduct;

    /**
     * The date of entry of the product ordered
     */
    private String dateEntryProduct;

    /**
     * The quantity of the product ordered
     */
    private int quantity;

    /**
     * A OrderDetais object represent the table "order_details" from the database
     * 
     * @param idOrder          The id of the order ordered
     * @param idProduct        The id of the product ordered
     * @param dateEntryProduct The date of entry of the product ordered
     * @param quantity         The quantity of the product ordered
     */
    public OrderDetails(int idOrder, int idProduct, String dateEntryProduct, int quantity) {
        this.setIdOrder(idOrder);
        this.setIdProduct(idProduct);
        this.setDateEntryProduct(dateEntryProduct);
        this.setQuantity(quantity);
    }

    /**
     * @return int
     */
    public int getIdOrder() {
        return this.idOrder;
    }

    /**
     * @param idOrder
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * @return int
     */
    public int getIdProduct() {
        return this.idProduct;
    }

    /**
     * @param idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return String
     */
    public String getDateEntryProduct() {
        return this.dateEntryProduct;
    }

    /**
     * @param dateEntryProduct
     */
    public void setDateEntryProduct(String dateEntryProduct) {
        this.dateEntryProduct = dateEntryProduct;
    }

    /**
     * @return int
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return String
     */
    public String toString() {
        return "{\n\tidOrder => \"" + this.idOrder + "\",\n\tidProduct => \"" + this.idProduct
                + "\",\n\tdateEntryProduct  => \"" + this.dateEntryProduct + "\",\n\tquantity  => \"" + this.quantity
                + "\"\n}";
    }

    /**
     * Insert the OrderDetails into the database
     */
    public void store() {
        OrderDetailsManager.store(this);
    }

    /**
     * Updates the OrderDetails in the database
     * 
     * @param OrderDetails  orderDetails
     */
    public void update(OrderDetails orderDetails) {
        OrderDetailsManager.update(this.getIdOrder(), this.getIdProduct(), orderDetails);
    }

    /**
     * Deletes the OrderDetails from the database
     * 
     * @return int The satus of the deletion
     */
    public int delete() {
        return OrderDetailsManager.delete(this.idOrder, this.idProduct);
    }
}

package Model.entities;

import Model.entitiesManagers.StockManager;

/**
 * Represents the table "stock" of the database as an application entity
 * 
 * @author mawena
 */
public class Stock {
    private int idProduct;
    private String dateEntryProduct;
    private int quantity;

    public Stock(int idProduct, String dateEntryProduct, int quantity) {
        this.setIdProduct(idProduct);
        this.setDateEntryProduct(dateEntryProduct);
        this.setQuantity(quantity);
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
        return "{\n\tidProduct => \"" + this.idProduct + "\",\n\tdateEntryProduct => \"" + this.dateEntryProduct
                + "\",\n\tquantity => \"" + this.quantity + "\"\n}";
    }

    /**
     * Insert the stock into the database
     */
    public void store() {
        StockManager.store(this);
    }

    /**
     * Updates the stock in the database
     * 
     * @param   Stock   stock
     */
    public void update(Stock stock) {
        StockManager.update(this.getIdProduct(), this.getDateEntryProduct(), stock);
    }

    /**
     * Deletes the stock into the database
     * 
     * @return int
     */
    public int delete() {
        return StockManager.delete(this.idProduct, this.dateEntryProduct);
    }
}

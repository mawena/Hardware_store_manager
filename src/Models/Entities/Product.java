package Models.Entities;

import Models.EntitiesManagers.ProductManager;

/**
 * Represents the table "products" of the database as an application entity
 * 
 * @author mawena
 */
public class Product {

    /**
     * The product's idientifiant into the database
     */
    private int id;

    /**
     * The product's designation
     */
    private String designation;

    /**
     * The product's description
     */
    private String description;

    /**
     * The product's price
     */
    private double price;

    /**
     * A Product's object represent a row of the table products into the database
     */
    public Product(int id, String designation, String description, double price) {
        this.setId(id);
        this.setDesignation(designation);
        this.setDescription(description);
        this.setPrice(price);
    }

    /**
     * A Product's object represent a row of the table products into the database
     */
    public Product(String designation, String description, double price) {
        this.setDesignation(designation);
        this.setDescription(description);
        this.setPrice(price);
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
    public String getDesignation() {
        return this.designation;
    }

    /**
     * @param designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return double
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return String
     */
    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tdesignation => \"" + this.designation + "\",\n\tdescription  => \""
                + this.description + "\",\n\tprice  => \"" + this.price + "\"\n}";
    }

    /**
     * Insert the product into the database
     */
    public void store() {
        Product tmp = ProductManager.store(this);
        this.setId(tmp.getId());
    }

    /**
     * Update the product in the database
     * @param Product   product
     */
    public void update(Product product) {
        ProductManager.update(this.getId(), product);
    }

    /**
     * Delete the product from the database
     * @return int
     */
    public int delete() {
        return ProductManager.delete(this.id);
    }
}

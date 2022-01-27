package Models.Entities;

import Models.EntitiesManagers.ProductsManager;

public class Product {

    private int id;

    private String designation;

    private String description;

    private double price;

    public Product(int id, String designation, String description, double price) {
        this.setId(id);
        this.setDesignation(designation);
        this.setDescription(description);
        this.setPrice(price);
    }

    public Product(String designation, String description, double price) {
        this.setDesignation(designation);
        this.setDescription(description);
        this.setPrice(price);
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return this.description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "{\n\tid => \"" + this.id + "\",\n\tdesignation => \"" + this.designation + "\",\n\tdescription  => \""
                + this.description + "\",\n\tprice  => \"" + this.price + "\"\n}";
    }

    public void store() {
        Product tmp = ProductsManager.store(this);
        this.setId(tmp.getId());
    }

    public void update(Product product) {
        ProductsManager.update(this.getId(), product);
    }

    
    public boolean delete() {
        return ProductsManager.delete(this.id);
    }
}

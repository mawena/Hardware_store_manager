package Models.Entities;

import Models.EntitiesManagers.StockManager;

public class Stock {

    private int idProduct;
    private String dateEntryProduct;
    private int quantity;
    private String productDesignation;

    public Stock(int idProduct, String dateEntryProduct, int quantity, String productDesignation) {
        this.setIdProduct(idProduct);
        this.setDateEntryProduct(dateEntryProduct);
        this.setQuantity(quantity);
        this.setProductDesignation(productDesignation);
    }

    public String toString() {
        return "{\n\tidProduct => \"" + this.idProduct + "\",\n\tproductDesignation => \"" + this.productDesignation + "\",\n\tdateEntryProduct => \"" + this.dateEntryProduct
                + "\",\n\tquantity => \"" + this.quantity + "\"\n}";
    }

    public void store() {
        StockManager.store(this);
    }

    public void update(Stock stock) {
        StockManager.update(this.getIdProduct(), this.getDateEntryProduct(), stock);
    }

    public boolean delete() {
        return StockManager.delete(this.idProduct, this.dateEntryProduct);
    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDateEntryProduct() {
        return this.dateEntryProduct;
    }

    public void setDateEntryProduct(String dateEntryProduct) {
        this.dateEntryProduct = dateEntryProduct;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductDesignation() {
        return productDesignation;
    }

    public void setProductDesignation(String productDesignation) {
        this.productDesignation = productDesignation;
    }
}

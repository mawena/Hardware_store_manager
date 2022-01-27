package Models.Entities;

import Models.EntitiesManagers.OrderDetailsManager;

public class OrderDetails {

    private int idOrder;

    private int idProduct;

    private String dateEntryProduct;

    private int quantity;

    public OrderDetails(int idOrder, int idProduct, String dateEntryProduct, int quantity) {
        this.setIdOrder(idOrder);
        this.setIdProduct(idProduct);
        this.setDateEntryProduct(dateEntryProduct);
        this.setQuantity(quantity);
    }

    public int getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public String toString() {
        return "{\n\tidOrder => \"" + this.idOrder + "\",\n\tidProduct => \"" + this.idProduct
                + "\",\n\tdateEntryProduct  => \"" + this.dateEntryProduct + "\",\n\tquantity  => \"" + this.quantity
                + "\"\n}";
    }

    public void store() {
        OrderDetailsManager.store(this);
    }

    public void update(OrderDetails orderDetails) {
        OrderDetailsManager.update(this.getIdOrder(), this.getIdProduct(), orderDetails);
    }

    public boolean delete() {
        return OrderDetailsManager.delete(this.idOrder, this.idProduct);
    }
}

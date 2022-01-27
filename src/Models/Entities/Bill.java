package Models.Entities;

import Models.EntitiesManagers.BillsManager;

public class Bill {

    private int idOrder;
    private String dateBill;

    public Bill(int idOrder, String dateBill) {
        this.setIdOrder(idOrder);
        this.setDateBill(dateBill);
    }

    public int getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateBill() {
        return this.dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public String toString() {
        return "{\n\tidOrder => \"" + this.idOrder + "\",\n\tdateBill  => \"" + this.dateBill + "\"\n}";
    }

    public void store() {
        BillsManager.store(this);
    }

    public void update(Bill bill) {
        BillsManager.update(this.getIdOrder(), bill);
    }

    public boolean delete() {
        return BillsManager.delete(this.idOrder);
    }
}

package Model.entities;

import Model.entitiesManagers.BillManager;

/**
 * Represents the table "bills" of the database as an application entity
 * 
 * @author mawena
 */
public class Bill {
    private int idOrder;
    private String dateBill;

    public Bill(int idOrder, String dateBill) {
        this.setIdOrder(idOrder);
        this.setDateBill(dateBill);
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
     * @return String
     */
    public String getDateBill() {
        return this.dateBill;
    }

    /**
     * @param dateBill
     */
    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    /**
     * @return String
     */
    public String toString() {
        return "{\n\tidOrder => \"" + this.idOrder + "\",\n\tdateBill  => \"" + this.dateBill + "\"\n}";
    }

    /**
     * Insert the Bill into the database
     */
    public void store() {
        BillManager.store(this);
    }

    /**
     * Updates the Bill in the database
     * 
     * @param   Bill   bill
     */
    public void update(Bill bill) {
        BillManager.update(this.getIdOrder(), bill);
    }

    /**
     * Deletes the Bill from the database
     * 
     * @return int
     */
    public int delete() {
        return BillManager.delete(this.idOrder);
    }
}

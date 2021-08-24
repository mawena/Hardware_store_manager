package bdd.entities;

import bdd.entitiesManagers.BillManager;

public class Bill {
    private int idOrder;
    private String dateBill;

    public Bill(int idOrder, String dateBill){
        this.setIdOrder(idOrder);
        this.setDateBill(dateBill);
    }

    
    /** 
     * @return int
     */
    public int getIdOrder(){
        return this.idOrder;
    }

    
    /** 
     * @param idOrder
     */
    public void setIdOrder(int idOrder){
        this.idOrder = idOrder;
    }

    
    /** 
     * @return String
     */
    public String getDateBill(){
        return this.dateBill;
    }

    
    /** 
     * @param dateBill
     */
    public void setDateBill(String dateBill){
        this.dateBill = dateBill;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "{\n\tidOrder => \"" + this.idOrder + "\",\n\tdateBill  => \"" + this.dateBill + "\"\n}";
    }

    public void store(){
        BillManager.store(this);
    }

    public void update(){
        BillManager.update(this);
    }

    
    /** 
     * @return int
     */
    public int delete(){
        return BillManager.delete(this.idOrder);
    }
}

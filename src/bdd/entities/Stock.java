package bdd.entities;

import bdd.entitiesManagers.stockManager;
/**
 * @author mawena
 */
public class Stock {
    private int idProduct;
    private String dateEntryProduct;
    private int quantity;

    public Stock(int idProduct, String dateEntryProduct, int quantity){
        this.setIdProduct(idProduct);
        this.setDateEntryProduct(dateEntryProduct);
        this.setQuantity(quantity);
    }

    
    /** 
     * @return int
     */
    public int getIdProduct(){
        return this.idProduct;
    }

    
    /** 
     * @param idProduct
     */
    public void setIdProduct(int idProduct){
        this.idProduct = idProduct;
    }

    
    /** 
     * @return String
     */
    public String getDateEntryProduct(){
        return this.dateEntryProduct;
    }

    
    /** 
     * @param dateEntryProduct
     */
    public void setDateEntryProduct(String dateEntryProduct){
        this.dateEntryProduct = dateEntryProduct;
    }

    
    /** 
     * @return int
     */
    public int getQuantity(){
        return this.quantity;
    }

    
    /** 
     * @param quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

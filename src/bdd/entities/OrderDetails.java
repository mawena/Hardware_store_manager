package bdd.entities;

public class OrderDetails {
    private int idOrder;
    private int idProduct;
    private String dateOrder;
    private String dateEntryProduct;
    private int quantity;


    
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
    public String getDateOrder(){
        return this.dateOrder;
    }

    
    /** 
     * @param dateOrder
     */
    public void setDateOrder(String dateOrder){
        this.dateOrder = dateOrder;
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

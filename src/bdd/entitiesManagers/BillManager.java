package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Bill;

public class BillManager extends Manager{
    
    
    /** 
     * Find a bill using its idOrder
     * @param idOrder
     * @return Bill
     */
    public static Bill get(int idOrder){
        Bill bill = null;
        try{
            pS = connection.prepareStatement("SELECT * FROM bills WHERE id = ?");
            pS.setInt(1, idOrder);
            result = pS.executeQuery();
            while(result.next()){
                bill = new Bill(result.getInt("id_order"), result.getString("date_bill"));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.print(e);
        }
        return bill;
    }

    
    /** 
     * Find all bill into the database
     * @return ArrayList<Bill>
     */
    public static ArrayList<Bill> getAll(){
        ArrayList<Bill> billList = new ArrayList<Bill>();
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM bills;");
            while(result.next()){
                billList.add(new Bill(result.getInt("id_order"), result.getString("date_bill")));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return billList;
    }

    
    /** 
     * Store a bill
     * @param bill
     * @return Bill
     */
    public static Bill store(Bill bill){
        try{
            pS = connection.prepareStatement("INSERT INTO bills(id_order, date_bill) VALUES(?, ?);");
            pS.setInt(1, bill.getIdOrder());
            pS.setString(2, bill.getDateBill());
            pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return bill;
    }

    
    /** 
     * Update a bill
     * @param bill
     * @return Bill
     */
    public static Bill update(Bill bill){
        try{
            pS = connection.prepareStatement("UPDATE bills SET id_order = ?, date_bill = ? WHERE id_order = ?;");
            pS.setInt(1, bill.getIdOrder());
            pS.setString(2, bill.getDateBill());
            pS.setInt(3, bill.getIdOrder());
            pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return bill;
    }

    
    /** 
     * Delete a bill using her idOrder
     * @param idOrder
     * @return int
     */
    public static int delete(int idOrder){
        int status = 0;
        try{
            pS = connection.prepareStatement("DELETE FROM bills WHERE id_order = ?;");
            pS.setInt(1, idOrder);
            status = pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
}

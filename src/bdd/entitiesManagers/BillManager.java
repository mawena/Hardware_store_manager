package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Bill;

/**
 * Contains static methods for selection, inserting, updating, and removing Bill
 * in the database
 * 
 * @author mawena
 */
public class BillManager extends Manager {

    /**
     * Returns a specific Bill from the database
     * 
     * @param idOrder The idOrder of the Bill found
     * @return Bill The Bill found
     */
    public static Bill get(int idOrder) {
        Bill bill = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM bills WHERE id_order = ?");
            pS.setInt(1, idOrder);
            result = pS.executeQuery();
            while (result.next()) {
                bill = new Bill(result.getInt("id_order"), result.getString("date_bill"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.print(e);
        }
        return bill;
    }

    /**
     * Returns an ArrayList of all Bill from the database
     * 
     * @return ArrayList<Bill>
     */
    public static ArrayList<Bill> getAll() {
        ArrayList<Bill> billList = new ArrayList<Bill>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM bills;");
            while (result.next()) {
                billList.add(new Bill(result.getInt("id_order"), result.getString("date_bill")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return billList;
    }

    /**
     * Insert a Bill into the database
     * 
     * @param bill The Bill that will be inserted
     * @return Bill The Bill that has been inserted
     */
    public static Bill store(Bill bill) {
        try {
            pS = connection.prepareStatement("INSERT INTO bills(id_order, date_bill) VALUES(?, NOW());");
            pS.setInt(1, bill.getIdOrder());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return bill;
    }

    /**
     * Updates a Bill in the database
     * 
     * @param idOrder The idOrder of the old Bill
     * @param bill    The new Bill
     * @return Bill The new Bill
     */
    public static Bill update(int idOrder, Bill bill) {
        try {
            pS = connection.prepareStatement("UPDATE bills SET id_order = ?, date_bill = ? WHERE id_order = ?;");
            pS.setInt(1, bill.getIdOrder());
            pS.setString(2, bill.getDateBill());
            pS.setInt(3, idOrder);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bill;
    }

    /**
     * Deletes a Bill from the database
     * 
     * @param idOrder The idOrder of the Bill
     * @return int The status of the deletion
     */
    public static int delete(int idOrder) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM bills WHERE id_order = ?;");
            pS.setInt(1, idOrder);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}

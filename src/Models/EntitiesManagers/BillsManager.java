package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Bill;

public class BillsManager extends Manager {

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

    public static boolean delete(int idOrder) {
        try {
            pS = connection.prepareStatement("DELETE FROM bills WHERE id_order = ?;");
            pS.setInt(1, idOrder);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}

package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Bill;
import Models.Entities.Order;
import Models.Entities.OrderDetails;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BillsManager extends Manager {

    public static Bill get(int idOrder) {
        Bill bill = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM bills WHERE id_order = ?");
            pS.setInt(1, idOrder);
            result = pS.executeQuery();
            while (result.next()) {
                bill = new Bill(result.getInt("id_order"), result.getString("date_bill"), result.getDouble("getMoney"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bill;
    }

    public static ArrayList<Bill> getAll() {
        ArrayList<Bill> billList = new ArrayList<Bill>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM bills;");
            while (result.next()) {
                billList.add(new Bill(result.getInt("id_order"), result.getString("date_bill"), result.getDouble("getMoney")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }

    public static Bill store(Bill bill) {
        try {
            pS = connection.prepareStatement("INSERT INTO bills(id_order, date_bill, getMoney) VALUES(?, ?, ?);");
            pS.setInt(1, bill.getIdOrder());
            pS.setString(2, bill.getDateBill());
            pS.setDouble(3, bill.getGetMoney());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return bill;
    }

    public static Bill update(int idOrder, Bill bill) {
        try {
            pS = connection.prepareStatement("UPDATE bills SET id_order = ?,date_bill = ?, getMoney = ? WHERE id_order = ?;");
            pS.setInt(1, bill.getIdOrder());
            pS.setString(2, bill.getDateBill());
            pS.setDouble(3, bill.getGetMoney());
            pS.setInt(4, idOrder);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<Bill> billList) {
        String col[] = {"Numéro commande", "Nom client", "Nom employé", "Total", "Somme payé", "Monaie", "Date commande", "Date facture"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Bill bill : billList) {
            Order order = OrdersManager.get(bill.getIdOrder());
            double total = 0;
            for (OrderDetails orderDetail : OrdersDetailsManager.getByOrder(order.getId())) {
                total = total + orderDetail.getQuantity();
            }
            Double totalAll = ((double)total)+bill.getGetMoney();
            Object[] obj = {bill.getIdOrder(), order.getClientName(), order.getEmployerName(), total, totalAll, bill.getGetMoney(), order.getClientName(), order.getDateOrder(), bill.getDateBill()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

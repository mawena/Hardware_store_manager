package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Stock;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StockManager extends Manager {

    public static Stock get(int idProduct, String dateEntryProduct) {
        Stock stock = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM stock, products WHERE stock.id_product = ? and stock.date_entry_product = ? and products.id = stock.id_product;");
            pS.setInt(1, idProduct);
            pS.setString(2, dateEntryProduct);
            result = pS.executeQuery();
            while (result.next()) {
                stock = new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity"), result.getString("designation"));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stock;
    }

    public static ArrayList<Stock> getByProduct(int idProduct) {
        ArrayList<Stock> stockList = new ArrayList<Stock>();

        try {
            pS = connection.prepareStatement("SELECT * FROM stock, products WHERE stock.id_product = ? and products.id = stock.id_product ORDER BY date_entry_product;");
            pS.setInt(1, idProduct);
            result = pS.executeQuery();
            while (result.next()) {
                stockList.add(new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity"), result.getString("designation")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return stockList;
    }

    public static ArrayList<Stock> getAll() {
        ArrayList<Stock> stockList = new ArrayList<Stock>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM stock, products WHERE products.id = stock.id_product ORDER BY date_entry_product DESC;");
            while (result.next()) {
                stockList.add(new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity"), result.getString("designation")));
            }
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stockList;
    }

    public static Stock store(Stock stock) {
        try {
            pS = connection.prepareStatement(
                    "INSERT INTO stock(id_product, date_entry_product, quantity) VALUE(?, ?, ?);");
            pS.setInt(1, stock.getIdProduct());
            pS.setString(2, stock.getDateEntryProduct());
            pS.setInt(3, stock.getQuantity());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return stock;
    }

    public static Stock update(int idProduct, String dateEntryProduct, Stock stock) {
        try {
            pS = connection.prepareStatement(
                    "UPDATE stock SET id_product = ?, date_entry_product = ?, quantity = ? WHERE id_product = ? and date_entry_product = ?;");
            pS.setInt(1, stock.getIdProduct());
            pS.setString(2, stock.getDateEntryProduct());
            pS.setInt(3, stock.getQuantity());
            pS.setInt(4, idProduct);
            pS.setString(5, dateEntryProduct);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stock;
    }

    public static boolean delete(int idProduct, String dateEntryProduct) {
        try {
            pS = connection.prepareStatement("DELETE FROM stock WHERE id_product = ? and date_entry_product = ?;");
            pS.setInt(1, idProduct);
            pS.setString(2, dateEntryProduct);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static TableModel toTableModel(ArrayList<Stock> stockList) {
        String col[] = {"Numéro produit", "Designation", "Quantié", "Date d'entrée"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Stock stock : stockList) {
            Object[] obj = {stock.getIdProduct(), stock.getProductDesignation(), stock.getQuantity(), stock.getDateEntryProduct()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }
}

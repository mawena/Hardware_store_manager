package Model.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Model.entities.Stock;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * stock in the database
 * 
 * @author mawena
 */
public class StockManager extends Manager {

    /**
     * Return a found Stock
     * 
     * @param idProduct        The identifiant of the product of the Stock found
     * @param dateEntryProduct The date of the entry of the product of the Stock
     *                         found
     * @return Stock The Stock found
     */
    public static Stock get(int idProduct, String dateEntryProduct) {
        Stock stock = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM stock WHERE id_product = ? and date_entry_product = ?;");
            pS.setInt(1, idProduct);
            pS.setString(2, dateEntryProduct);
            result = pS.executeQuery();
            while (result.next()) {
                stock = new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return stock;
    }

    /**
     * Return an ArrayList of all Stock with a certain idProduct
     * 
     * @param idProduct The idProduct
     * @return ArrayList<Stock>
     */
    public static ArrayList<Stock> getByProduct(int idProduct) {
        ArrayList<Stock> stockList = new ArrayList<Stock>();

        try {
            pS = connection.prepareStatement("SELECT * FROM stock WHERE id_product = ? ORDER BY date_entry_product;");
            pS.setInt(1, idProduct);
            result = pS.executeQuery();
            while (result.next()) {
                stockList.add(new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return stockList;
    }

    /**
     * Return an ArrayList of all Stock from the database
     * 
     * @return ArrayList<Stock>
     */
    public static ArrayList<Stock> getAll() {
        ArrayList<Stock> stockList = new ArrayList<Stock>();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM stock;");
            while (result.next()) {
                stockList.add(new Stock(result.getInt("id_product"), result.getString("date_entry_product"),
                        result.getInt("quantity")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return stockList;
    }

    /**
     * Insert a Stock into the database
     * 
     * @param stock The Stock that will be inserted
     * @return Stock The Stock that has been inserted
     */
    public static Stock store(Stock stock) {
        try {
            pS = connection.prepareStatement(
                    "INSERT INTO stock(id_product, date_entry_product, quantity) VALUE(?, NOW(), ?);");
            pS.setInt(1, stock.getIdProduct());
            pS.setInt(2, stock.getQuantity());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return stock;
    }

    /**
     * Updates a stock in the database
     * 
     * @param idProduct        The idProduct of old stock
     * @param dateEntryProduct The dateEntryProduct of old stock
     * @param stock            The new stock
     * @return Stock The new stock
     */
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
            System.out.println(e);
        }
        return stock;
    }

    /**
     * Deletes a Stock from the database
     * 
     * @param idProduct        The identifiant of the product of the Stock that will
     *                         be deleted
     * @param dateEntryProduct The date of the entry of the product of the Stock
     *                         that will be deleted
     * @return int The status of the deletion
     */
    public static int delete(int idProduct, String dateEntryProduct) {
        int status = 0;
        try {
            pS = connection.prepareStatement("DELETE FROM stock WHERE id_product = ? and date_entry_product = ?;");
            pS.setInt(1, idProduct);
            pS.setString(2, dateEntryProduct);
            status = pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author mawena
 */
public class OdersController {

    public static boolean isValid(Stock stock) {
        if (stock.getDateEntryProduct().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La date d'entrée du prouit est manquante!");
            return false;
        }
        return true;
    }

    public static boolean store(Stock stock) {
        if (isValid(stock)) {
            Stock stockDB = StockManager.get(stock.getIdProduct(), stock.getDateEntryProduct());
            if (stockDB == null) {
                return (StockManager.store(stock) != null);
            } else {
                JOptionPane.showMessageDialog(null, "Le produit est déjà dans le stock à cette date!\nVeuillez plutôt le mettre à jour");
                return false;
            }
        } else {
            return false;
        }

    }

    public static boolean update(int stockId, String stockDateEntryProduct, Stock stock) {
        Stock stockDB = StockManager.get(stock.getIdProduct(), stock.getDateEntryProduct());
        if (stockDB == null) {
            JOptionPane.showMessageDialog(null, "Le stock n'existe pas!");
            return false;
        } else {
            if (isValid(stock)) {
                return (StockManager.update(stockId, stockDateEntryProduct, stock) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int stockIdProduct, String stockDateEntryProduct) {
        Stock stockDB = StockManager.get(stockIdProduct, stockDateEntryProduct);
        if (stockDB == null) {
            JOptionPane.showMessageDialog(null, "Le stock sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le stock?") == 0) {
                return (StockManager.delete(stockIdProduct, stockDateEntryProduct));
            } else {
                return false;
            }
        }
    }

}

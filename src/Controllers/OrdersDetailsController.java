/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Entities.Order;
import Models.Entities.OrderDetails;
import Models.Entities.Stock;
import Models.EntitiesManagers.OrdersDetailsManager;
import Models.EntitiesManagers.OrdersManager;
import Models.EntitiesManagers.StockManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mawena
 */
public class OrdersDetailsController {

    public static boolean store(OrderDetails orderDetails) {

        OrderDetails orderDetailsDB = OrdersDetailsManager.get(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
        if (orderDetailsDB == null) {
            Stock stock = StockManager.get(orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
            if (stock.getQuantity() < orderDetails.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Le produit n'est pas en quantité sufisante");
            } else {
                if (OrdersDetailsManager.store(orderDetails) == null) {
                    return false;
                } else {
                    stock.setQuantity(stock.getQuantity() - orderDetails.getQuantity());
                    StockManager.update(stock.getIdProduct(), stock.getDateEntryProduct(), stock);
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La commande existe déjà");
            return false;
        }
        return false;
    }

    public static boolean update(OrderDetails orderDetails) {
        Stock stock = StockManager.get(orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
        OrderDetails oldOrderDetails = OrdersDetailsManager.get(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
        int response;
        if (orderDetails.getQuantity() > oldOrderDetails.getQuantity()) {
            int difference = (orderDetails.getQuantity() - oldOrderDetails.getQuantity());
            if (difference > stock.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Il n'y a pas assez de produit en stock pour ajouter");
                response = 1;
                return false;
            } else {
                if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment augmenter la quantité de ce produit?") == 0) {
                    OrdersDetailsManager.update(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails);
                    stock.setQuantity(stock.getQuantity() - difference);
                    StockManager.update(stock.getIdProduct(), stock.getDateEntryProduct(), stock);
                    return true;
                } else {
                    return false;
                }
            }
        } else if (orderDetails.getQuantity() == oldOrderDetails.getQuantity()) {
            JOptionPane.showMessageDialog(null, "Aucun changement");
            return true;
        } else {
            int difference = (oldOrderDetails.getQuantity() - orderDetails.getQuantity());
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment dimminuer la quantité de ce produit?") == 0) {
                OrdersDetailsManager.update(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails);
                stock.setQuantity(stock.getQuantity() + difference);
                StockManager.update(stock.getIdProduct(), stock.getDateEntryProduct(), stock);
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(OrderDetails orderDetails) {
        Stock stock = StockManager.get(orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
        if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment retirer le produit de la commande?") == 0) {
            if (OrdersDetailsManager.delete(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails.getDateEntryProduct())) {
                stock.setQuantity(stock.getQuantity() + orderDetails.getQuantity());
                StockManager.update(stock.getIdProduct(), stock.getDateEntryProduct(), stock);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

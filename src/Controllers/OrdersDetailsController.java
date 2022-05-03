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
            Stock productStock = StockManager.get(orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
            if (productStock.getQuantity() < orderDetails.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Le produit n'est pas en quantité sufisante");
            } else {
                if (OrdersDetailsManager.store(orderDetails) == null) {
                    return false;
                } else {
                    productStock.setQuantity(productStock.getQuantity() - orderDetails.getQuantity());
                    StockManager.update(productStock.getIdProduct(), productStock.getDateEntryProduct(), productStock);
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La commande existe déjà");
            return false;
        }
        return false;
    }

    public static boolean update(int orderId, Order order) {
        Order orderDB = OrdersManager.get(orderId);
        if (orderDB == null) {
            JOptionPane.showMessageDialog(null, "La commande n'existe pas!");
            return false;
        } else {
            return (OrdersManager.update(orderId, order) != null);
        }
    }

    public static boolean destroy(OrderDetails orderDetails) {
        Stock productStock = StockManager.get(orderDetails.getIdProduct(), orderDetails.getDateEntryProduct());
        
        if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le order?") == 0) {
            if(OrdersDetailsManager.delete(orderDetails.getIdOrder(), orderDetails.getIdProduct(), orderDetails.getDateEntryProduct())){
                productStock.setQuantity(productStock.getQuantity() + orderDetails.getQuantity());
                StockManager.update(productStock.getIdProduct(), productStock.getDateEntryProduct(), productStock);
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

}

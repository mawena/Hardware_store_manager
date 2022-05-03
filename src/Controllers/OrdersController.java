/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Entities.Order;
import Models.EntitiesManagers.OrdersManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mawena
 */
public class OrdersController {

    public static boolean isValid(Order order) {
        if (order.getDateOrder().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La date d'entrée du prouit est manquante!");
            return false;
        }
        return true;
    }

    public static boolean store(Order order) {
        if (isValid(order)) {
            Order orderDB = OrdersManager.get(order.getIdClient(), order.getIdEmployer(), order.getDateOrder());
            if (orderDB == null) {
                return (OrdersManager.store(order) != null);
            } else {
                JOptionPane.showMessageDialog(null, "La commande existe déjà");
                return false;
            }
        } else {
            return false;
        }

    }

    public static boolean update(int orderId, Order order) {
        Order orderDB = OrdersManager.get(orderId);
        if (orderDB == null) {
            JOptionPane.showMessageDialog(null, "La commande n'existe pas!");
            return false;
        } else {
            if (isValid(order)) {
                return (OrdersManager.update(orderId, order) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int orderId) {
        Order orderDB = OrdersManager.get(orderId);
        if (orderDB == null) {
            JOptionPane.showMessageDialog(null, "Le order sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer le order?") == 0) {
                return (OrdersManager.delete(orderId));
            } else {
                return false;
            }
        }
    }

}

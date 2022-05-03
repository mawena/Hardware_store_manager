/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Entities.Bill;
import Models.Entities.Order;
import Models.Entities.OrderDetails;
import Models.EntitiesManagers.BillsManager;
import Models.EntitiesManagers.OrdersDetailsManager;
import Models.EntitiesManagers.OrdersManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mawena
 */
public class BillsController {

    public static boolean isValid(Bill bill) {
        if (bill.getDateBill().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La date d'entrée de la facture est manquante!");
            return false;
        }
        return true;
    }

    public static boolean store(Double amountPaid, Bill bill) {
        if (isValid(bill)) {
            Bill billDB = BillsManager.get(bill.getIdOrder());
            if (billDB == null) {
                Order order = OrdersManager.get(bill.getIdOrder());
                double total = 0;
                for (OrderDetails orderDetail : OrdersDetailsManager.getByOrder(order.getId())) {
                    total = total + orderDetail.getQuantity();
                }
                if (amountPaid < total) {
                    JOptionPane.showMessageDialog(null, "Le montant donné est inférieur à la somme sur la facture");
                    return false;
                } else {
                    bill.setGetMoney(amountPaid - total);
                    return (BillsManager.store(bill) != null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La facture existe déjà");
                return false;
            }
        } else {
            return false;
        }

    }

    public static boolean update(int orderId, Double amountPaid, Bill bill) {
        Bill billDB = BillsManager.get(orderId);
        if (billDB == null) {
            JOptionPane.showMessageDialog(null, "La facture n'existe pas!");
            return false;
        } else {
            if (isValid(bill)) {
                Order order = OrdersManager.get(bill.getIdOrder());
                double total = 0;
                for (OrderDetails orderDetail : OrdersDetailsManager.getByOrder(order.getId())) {
                    total = total + orderDetail.getQuantity();
                }
                if (amountPaid < total) {
                    JOptionPane.showMessageDialog(null, "Le montant donné est inférieur à la somme sur la facture");
                    return false;
                } else {
                    bill.setGetMoney(amountPaid - total);
                    return (BillsManager.update(orderId, bill) != null);
                }
                
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int orderId) {
        Bill billDB = BillsManager.get(orderId);
        if (billDB == null) {
            JOptionPane.showMessageDialog(null, "La facture sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer la facture?") == 0) {
                return (BillsManager.delete(orderId));
            } else {
                return false;
            }
        }
    }

}

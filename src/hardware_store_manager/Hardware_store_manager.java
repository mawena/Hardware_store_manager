/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware_store_manager;

import bdd.entities.*;
import bdd.entitiesManagers.*;

/**
 *
 * @author mawena
 */
public class Hardware_store_manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager.connect();

        Product product = ProductManager.get(2);
        product.delete();
        
        System.out.println("---------products-----------\n" + ProductManager.getAll() + "\n---------------------\n\n");
        System.out.println("---------users--------------\n" + UserManager.getAll() + "\n---------------------\n\n");
        System.out.println("---------clients------------\n" + ClientManager.getAll() + "\n---------------------\n\n");
        
        Manager.close();
    }
}

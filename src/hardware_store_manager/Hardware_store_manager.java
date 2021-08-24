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

        Employer em = EmployerManager.get(9);
        em.setId(1);
        em.update();

        System.out.println("\n\n" + ClientManager.getAll() + "\n\n");
        System.out.println("\n\n" + EmployerManager.getAll() + "\n\n");
        
        Manager.close();
    }
}

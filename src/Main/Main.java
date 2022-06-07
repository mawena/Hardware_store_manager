/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.JFrames.MainFrame;

import View.JFrames.LoginFrame;
import Models.EntitiesManagers.Manager;
import Controllers.UsersController;
import Models.Entities.User;
import javax.swing.JFrame;

/**
 *
 * @author mawena
 */
public class Main {

    private static LoginFrame login = null;
    private static MainFrame mainFrame = null;
    private static User currentUser = null;

    public static void main(String args[]) {
        Manager.connect();
        login = new LoginFrame();
        login.setLocationRelativeTo(null);
        //login.setVisible(true);
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    public static void connectUser(String username, String password, String type) {
        if (UsersController.login(username, password, type)) {
            mainFrame = new MainFrame();
            mainFrame.setLocationRelativeTo(login);
            mainFrame.setVisible(true);
            
            login.setVisible(false);
            login = null;
            Main.currentUser = new User(username, password, type);
        }
    }

    public static void disconnectUser() {
        login = new LoginFrame();
        login.setLocationRelativeTo(mainFrame);
        login.setVisible(true);
        
        mainFrame.setVisible(false);
        mainFrame = null;
        
        Main.currentUser = null;
    }

    public static void close() {
        Manager.close();
        System.exit(0);
    }

    public static void showOrderDetails(int parseInt) {
        mainFrame.showOrderDetails(parseInt);
    }
}

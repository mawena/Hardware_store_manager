/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import View.JFrames.MainFrame;


import View.JFrames.LoginFrame;
import Model.entitiesManagers.Manager;
import Controller.UserController;

/**
 *
 * @author mawena
 */
public class Main{

    private static LoginFrame login = new LoginFrame();
    private static MainFrame mainFrame = new MainFrame();
    
    public static void main(String args[]){
        Manager.connect();
        login.setVisible(true);
    }
    
    public static void connectUser(String username, String password, String type){
        if(UserController.login(username, password, type)){
            mainFrame.setVisible(true);
            login.setVisible(false);
        }
    }
}

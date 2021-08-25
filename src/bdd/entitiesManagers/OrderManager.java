package bdd.entitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import bdd.entities.Order;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * order in the database
 * 
 * @author mawena
 */
public class OrderManager extends Manager{
    
    public static Order get(int id){
        Order order = null;
        try{
            pS = connection.prepareStatement("SELECT * FROM orders WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while(result.next()){
                order = new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer"));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return order;
    }
    
    public static ArrayList<Order> getAll(){
        ArrayList<Order> orderList = new ArrayList<Order>();
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM orders;");
            while(result.next()){
                orderList.add(new Order(result.getInt("id"), result.getInt("id_client"), result.getInt("id_employer")));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return orderList;
    }

    public static Order store(Order order){
        try{
            pS = connection.prepareStatement("INSERT INTO order(id_client, id_employer) VALUES(?, ?);");
            pS.setInt(1, order.getIdClient());
            pS.setInt(2, order.getIdEmployer());
            pS.executeUpdate();
            closeQuery();
            order.setId(getLastId("orders"));
        }catch(SQLException e){
            System.out.println(e);
        }
        return order;
    }

    public static Order update(Order order){
        try {
            pS = connection.prepareStatement("UPDATE orders SET id = ?, id_client = ?, id_employer = ? WHERE id = ?;");
            pS.setInt(1, order.getId());
            pS.setInt(2, order.getIdClient());
            pS.setInt(3, order.getIdEmployer());
            pS.setInt(4, order.getId());
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    public static int delete(int id){
        int status = 0;
        try{
            pS = connection.prepareStatement("DELETE FROM orders WHERE id = ?");
            pS.setInt(1, id);
            status = pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
}

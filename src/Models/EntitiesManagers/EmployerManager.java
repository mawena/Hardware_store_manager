package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Employer;

/**
 * Contains static methods for selection, inserting, updating, and removing
 * employer in the database
 * 
 * @author mawena
 */
public class EmployerManager extends Manager{
    
    /** 
     * Return an employer from the database
     * @param id Integer The employer's id in the database
     * @return Employer
     */
    public static Employer get(int id){
        Employer employer = null;
        try{
            pS = connection.prepareStatement("SELECT * FROM employers WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while(result.next()){
                employer = new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex").charAt(0), result.getString("role"));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return employer;
    }

    
    /** 
     * Return an ArrayList of all employer from the database
     * @return ArrayList
     */
    public static ArrayList<Employer> getAll(){
        ArrayList<Employer> employerList = new ArrayList();
        try{
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM employers;");
            while(result.next()){
                employerList.add(new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex").charAt(0), result.getString("role")));
            }
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return employerList;
    }

    
    /** 
     * Insert an employer into the database
     * @param employer Employer The employer that will be inserted
     * @return Employer The employer that has been inserted
     */
    public static Employer store(Employer employer){
        try{
            pS = connection.prepareStatement("INSERT INTO employers(last_name, first_name, birth_date, sex, role) VALUES(?, ?, ?, ?, ?);");
            pS.setString(1, employer.getLastName());
            pS.setString(2, employer.getFirstName());
            pS.setString(3, employer.getBirthDate());
            pS.setString(4, "" + employer.getSex());
            pS.setString(5, employer.getRole());
            pS.executeUpdate();
            employer.setId(getLastId("employers"));
            closeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return employer;
    }

    
    /** 
     * Updates an employer in the database
     * @param id Integer The id of the employer that will be updated
     * @param employer Employer  The new employer
     * @return Employer The new employer
     */
    public static Employer update(int id, Employer employer){
        try{
            pS = connection.prepareStatement("UPDATE employers SET id = ?, last_name = ?, first_name = ?, birth_date = ?, sex = ?, role = ? WHERE id = ?;");
            pS.setInt(1, employer.getId());
            pS.setString(2, employer.getLastName());
            pS.setString(3, employer.getFirstName());
            pS.setString(4, employer.getBirthDate());
            pS.setString(5, "" + employer.getSex());
            pS.setString(6, employer.getRole());
            pS.setInt(7, id);
            pS.executeUpdate();
            closeQuery();
            System.out.println("Les roses2");
        }catch(SQLException e){
            System.out.println(e);
        }
        return employer;
    }

    
    /** 
     * Deletes an employer from the database
     * @param id Integer The id of the employer
     * @return int
     */
    public static int delete (int id){
        int satus = 0;
        try{
            pS = connection.prepareStatement("DELETE FROM employers WHERE id = ?;");
            pS.setInt(1, id);
            satus = pS.executeUpdate();
            closeQuery();
        }catch(SQLException e){ 
            System.out.println(e);
        }
        return satus;
    }
}

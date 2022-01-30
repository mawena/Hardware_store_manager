package Models.EntitiesManagers;

import java.sql.SQLException;
import java.util.ArrayList;
import Models.Entities.Employer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmployersManager extends Manager {

    public static Employer get(int id) {
        Employer employer = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM employers WHERE id = ?;");
            pS.setInt(1, id);
            result = pS.executeQuery();
            while (result.next()) {
                employer = new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex"), result.getString("rule"), result.getString("tel"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employer;
    }

    public static Employer get(String lastName, String firstName) {
        Employer employer = null;
        try {
            pS = connection.prepareStatement("SELECT * FROM employers WHERE last_name = ? AND first_name = ?;");
            pS.setString(1, lastName);
            pS.setString(2, firstName);
            result = pS.executeQuery();
            while (result.next()) {
                employer = new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex"), result.getString("rule"), result.getString("tel"));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employer;
    }
    
    public static ArrayList<Employer> search(String value) {
        ArrayList<Employer> employerList = new ArrayList();
        try {
            pS = connection.prepareStatement("SELECT * FROM employers WHERE last_name LIKE '%" + value + "%' OR first_name LIKE '%" + value + "%';");
            pS.setString(1, "value");
            result = pS.executeQuery();
            
            while (result.next()) {
                employerList.add(new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex"), result.getString("rule"), result.getString("tel")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employerList;
    }
    
    public static ArrayList<Employer> getAll() {
        ArrayList<Employer> employerList = new ArrayList();
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM employers;");
            while (result.next()) {
                employerList.add(new Employer(result.getInt("id"), result.getString("last_name"), result.getString("first_name"), result.getString("birth_date"), result.getString("sex"), result.getString("rule"), result.getString("tel")));
            }
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employerList;
    }

    public static Employer store(Employer employer) {
        try {
            pS = connection.prepareStatement("INSERT INTO employers(last_name, first_name, birth_date, sex, rule, tel) VALUES(?, ?, ?, ?, ?, ?);");
            pS.setString(1, employer.getLastName());
            pS.setString(2, employer.getFirstName());
            pS.setString(3, employer.getBirthDate());
            pS.setString(4, employer.getSex());
            pS.setString(5, employer.getRule());
            pS.setString(6, employer.getTel());
            pS.executeUpdate();
            employer.setId(getLastId("employers"));
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employer;
    }

    public static Employer update(int id, Employer employer) {
        try {
            pS = connection.prepareStatement("UPDATE employers SET last_name = ?, first_name = ?, birth_date = ?, sex = ?, rule = ?, tel = ? WHERE id = ?;");
            pS.setString(1, employer.getLastName());
            pS.setString(2, employer.getFirstName());
            pS.setString(3, employer.getBirthDate());
            pS.setString(4, employer.getSex());
            pS.setString(5, employer.getRule());
            pS.setString(6, employer.getTel());
            pS.setInt(7, id);
            pS.executeUpdate();
            closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employer;
    }

    public static boolean delete(int id) {
        try {
            pS = connection.prepareStatement("DELETE FROM employers WHERE id = ?;");
            pS.setInt(1, id);
            pS.executeUpdate();
            closeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static TableModel toTableModel(ArrayList<Employer> employerList) {
        String col[] = {"Numéro employer", "Nom", "Prénom", "Date naissance", "Sexe", "Fonction", "Tel"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Employer employer : employerList) {
            Object[] obj = {employer.getId(), employer.getLastName(), employer.getFirstName(), employer.getBirthDate(), employer.getSex(), employer.getRule(), employer.getTel()};
            tableModel.addRow(obj);
        }
        return tableModel;
    }

}

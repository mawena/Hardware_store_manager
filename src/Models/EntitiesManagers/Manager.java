package Models.EntitiesManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Contains static methods for managing the connection to the database and input
 * with the database
 */
public class Manager {
    protected static Connection connection;
    protected static Statement statement;
    protected static PreparedStatement pS;
    protected static ResultSet result;

    /**
     * Used to connect the manager at the database
     */
    public static void connect() {
        String url = "jdbc:mysql://localhost:3306/hardware_store_manager";
        String user = "hardware_store_manager_user";
        String password = "root";
        Manager.connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Used to close the manager connexion
     */
    public static void close() {
        if (Manager.connection != null) {
            try {
                Manager.connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Used to close the Satement or PreparetedStatement or ResultSet object
     */
    public static void closeQuery() {
        if (Manager.statement != null) {
            try {
                Manager.statement.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (Manager.result != null) {
            try {
                Manager.result.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (Manager.pS != null) {
            try {
                Manager.pS.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Return the last id of a table into the database
     * 
     * @param tableName String The name of the table
     * @return Integer The last id
     */
    public static int getLastId(String tableName) {
        int id = 0;
        try {
            Manager.statement = UsersManager.connection.createStatement();
            Manager.result = Manager.statement.executeQuery("SELECT MAX(id) AS id FROM `" + tableName + "`;");
            while (Manager.result.next()) {
                id = Manager.result.getInt("id");
            }
            Manager.closeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    /**
     * @return Connection
     */
    // Getters and Setters

    public static Connection getConnection() {
        return Manager.connection;
    }

    /**
     * @param connection    Connection
     */
    public static void setConnection(Connection connection) {
        Manager.connection = connection;
    }

    /**
     * @return Statement
     */
    public static Statement getStatement() {
        return Manager.statement;
    }

    /**
     * @param statement Statement
     */
    public static void setStatement(Statement statement) {
        Manager.statement = statement;
    }

    /**
     * @return Statement
     */
    public static Statement getPreparedStatement() {
        return Manager.pS;
    }

    /**
     * @param pS    PreparedStatement
     */
    public static void setPreparedStatement(PreparedStatement pS) {
        Manager.pS = pS;
    }

    /**
     * @return ResultSet
     */
    public static ResultSet getResult() {
        return Manager.result;
    }

    /**
     * @param result    ResutlSet
     */
    public static void setResult(ResultSet result) {
        Manager.result = result;
    }
}

import Models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class DatabaseOperations {

    // Declare the JDBC objects.
    private Connection dbConn = null;
    private Statement stmt = null; // Creates and Runs SQL queries.
    private ResultSet rs = null;

    public DatabaseOperations() {
        // Use windows authentication.
        //String sqlServerConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;integratedSecurity=true;";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + Database.host + ":" + Database.port + " ;databaseName=" + Database.dbName + ";user=" + Database.userName + ";password=" + Database.password;
        try {
            // Load jdbc driver class.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver is not found....");
        }

        try {
            // Get connection.
            dbConn = DriverManager.getConnection(sqlServerConnectionUrl);
            System.out.println("Connection is successful.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } /*finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConn != null) {
                try {
                    dbConn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }*/
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            // Execute sql and return data result.
            String sqlQuery = "SELECT * FROM Person.Person WHERE BusinessEntityID < 200";
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(sqlQuery);

            // Loop the data of the corresponding table result and display the data.
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int businessEntityId = rs.getInt("BusinessEntityID");

                users.add(new User(firstName, lastName, businessEntityId));
                //System.out.println(firstName + " " + lastName + " " + businessEntityId);
            }
            return users;

        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

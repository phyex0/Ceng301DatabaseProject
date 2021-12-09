import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        connectToDatabase();
    }


    public static void connectToDatabase() {
        String sqlServerConnectionUrl = "jdbc:sqlserver://MONSTER-PC:1433;databaseName=AdventureWorks2019;user=sa;password=ekmek";

        // Use windows authentication.
        //String sqlServerConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;integratedSecurity=true;";

        // Declare the JDBC objects.
        Connection dbConn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load jdbc driver class.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Get connection.
            dbConn = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = "SELECT * FROM Person.Person WHERE BusinessEntityID < 200";
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(SQL);

            // Loop the data result and display the data.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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
        }
    }
}

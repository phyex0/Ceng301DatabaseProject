import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        connectToDatabase();
        //Test Code
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("	DepartmentID, Name, GroupName, ModifiedDate ");
        sql.append(" FROM HumanResources.Department ");

        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            System.out.println(name);
        }

        System.out.println("Ekmek");
        disconnectFromDatabase();

    }

    public static void connectToDatabase() {
        DatabaseUtilities.host = "MONSTER-PC:1433";
        DatabaseUtilities.databaseName = "AdventureWorks2019";
        DatabaseUtilities.userName = "sa";
        DatabaseUtilities.password = "ekmek";

        try {
            DatabaseUtilities.getConnection();
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
            return;
        }
    }

    public static void disconnectFromDatabase() {
        try {
            DatabaseUtilities.disconnect();
        } catch (Exception e) {
            System.out.println("Error disconnecting from database : " + e);
            return;
        }
    }
}

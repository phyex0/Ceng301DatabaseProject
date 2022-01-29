package Views;

import Entity.Person;
import Model.ModelData;
import Model.ModelInterface;
import Utility.DatabaseUtilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch (operationName) {
            case "select":
                return selectOperation(modelData);
            case "selectr":
                return selectOperationNew(modelData);
            case "insert":
                return insertOperation(modelData);
            case "update":
                return updateOperation(modelData);
            case "delete":
                return deleteOperation(modelData);
            case "select.gui":
                return selectGUI(modelData);
            case "insert.gui":
                return insertGUI(modelData);
            case "update.gui":
                return updateGUI(modelData);
            case "delete.gui":
                return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;


        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String user_profile = resultSet.getString("user_profile");

                // Display values
                System.out.print(id + "\t");
                System.out.print(first_name + "\t");
                System.out.print(last_name + "\t");
                System.out.print(email + "\t");
                System.out.print(password + "\t");
                System.out.print(user_profile);
                System.out.println();


            }
            resultSet.close();

        }
        return new ViewData("MainMenu", "");
    }

    ViewData selectOperationNew(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;


        if (!resultSet.isBeforeFirst()) {
            System.out.println("Wrong email or password!");
            return new ViewData("Register", "");
        }
        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String user_profile = resultSet.getString("user_profile");

                // Display values
                System.out.print(id + "\t");
                System.out.print(first_name + "\t");
                System.out.print(last_name + "\t");
                System.out.print(email + "\t");
                System.out.print(password + "\t");
                System.out.print(user_profile);
                System.out.println();

                System.out.println();
                System.out.println("NOTIFICATIONS");
                System.out.println();

                Connection dbConn = null;
                Statement stmt = null; // Creates and Runs SQL queries.
                ResultSet rs = null;

                dbConn = DatabaseUtilities.getConnection();

                // Execute sql and return data result.
                String sqlQuery = "SELECT * FROM dbo.AssignedTask WHERE destination_user =" + id;
                stmt = dbConn.createStatement();
                rs = stmt.executeQuery(sqlQuery);

                // Loop the data of the corresponding table result and display the data.
                int task_counter = 0;
                while (rs.next()) {
                    int sourceUser = rs.getInt("source_user");
                    int destinationUser = rs.getInt("destination_user");
                    int task_id = rs.getInt("task_id");
                    Date assigned_date = rs.getDate("assigned_date");
                    task_counter++;
                    //System.out.println(sourceUser + " " + destinationUser + " " + task_id + " " + assigned_date);
                    System.out.println("TaskId: " + task_id + " AssignedDate: " + assigned_date);
                }
                System.out.println("\nTotal Task: " + task_counter);

            }
            resultSet.close();
            return new ViewData("MainMenu", "");
        }
        return null;
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");
        Integer id = getInteger("id", true);
        String first_name = getString("first_name : ", true);
        String last_name = getString("last_name", true);
        String email = getEmail("email", true);
        String password = getString("password", true);
        String user_profile = getString("user_profile", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) whereParameters.put("id", id);
        if (first_name != null) whereParameters.put("first_name", first_name);
        if (last_name != null) whereParameters.put("last_name", last_name);
        if (email != null) whereParameters.put("email", email);
        if (password != null) whereParameters.put("password", password);
        if (user_profile != null) whereParameters.put("user_profile", user_profile);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "id, first_name, last_name, email, password, user_profile");

        List<Object> rows = new ArrayList<>();

        Integer id;
        String first_name, last_name, email, password, user_profile;
        do {
            System.out.println("Fields to insert:");
            id = ModelInterface.getRandomId("dbo.Person");
            first_name = getString("first_name : ", true);
            last_name = getString("last_name : ", true);
            email = getEmail("email : ", true);
            password = getString("password : ", true);
            user_profile = getString("user_profile : ", true);

            System.out.println();

            if (id != null && first_name != null && last_name != null && email != null && password != null && user_profile != null) {
                System.out.println(first_name + " " + last_name + " " + email + " " + password + " " + user_profile);
                rows.add(new Person(id, first_name, last_name, email, password, user_profile));
            }
        }
        while (id != null && first_name != null && last_name != null && email != null && password != null && user_profile != null);

        parameters.put("rows", rows);

        return new ViewData("Person", "insert", parameters);
    }


    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");

        int id = getInteger("id", true);
        String first_name = getString("first_name : ", true);
        String last_name = getString("last_name : ", true);
        String email = getEmail("email : ", true);
        String password = getString("password : ", true);
        String user_profile = getString("user_profile : ", true);


        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (first_name != null) updateParameters.put("first_name", first_name);
        if (last_name != null) updateParameters.put("last_name", last_name);
        if (email != null) updateParameters.put("email", email);
        if (password != null) updateParameters.put("password", password);
        if (user_profile != null) updateParameters.put("user_profile", user_profile);


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Person View";
    }
}
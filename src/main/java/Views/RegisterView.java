package Views;

import Entity.Person;
import Model.ModelData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        System.out.println("Login");

        String email, password;

        System.out.println("Fields to insert:");
        email = getString("email : ", true);
        password = getString("password : ", true);



        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                //int id = resultSet.getInt("id");
                //String first_name = resultSet.getString("first_name");
                //String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                //String user_profile = resultSet.getString("user_profile");


                // Display values
                //System.out.print(id + "\t");
                //System.out.print(first_name + "\t");
                //System.out.print(last_name + "\t");
                System.out.print(email + "\t");
                System.out.print(password + "\t");
                //System.out.print(user_profile);
                System.out.println();
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
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
        //Integer id = getInteger("id", true);
        //String first_name = getString("first_name : ", true);
        //String last_name = getString("last_name", true);
        String email = getString("email", true);
        String password = getString("password", true);
        //String user_profile = getString("user_profile", true);

        Map<String, Object> whereParameters = new HashMap<>();
        //if (id != null) whereParameters.put("id", id);
        //if (first_name != null) whereParameters.put("first_name", first_name);
        //if (last_name != null) whereParameters.put("last_name", last_name);
        if (email != null) whereParameters.put("email", email);
        if (password != null) whereParameters.put("password", password);
        //if (user_profile != null) whereParameters.put("user_profile", user_profile);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "email, password");

        List<Object> rows = new ArrayList<>();

        //Integer id;
        //String first_name, last_name, email, password, user_profile;
        String email, password;
        do {
            System.out.println("Fields to insert:");
            //id = getInteger("id : ", true);
            //first_name = getString("first_name : ", true);
            //last_name = getString("last_name : ", true);
            email = getString("email : ", true);
            password = getString("password : ", true);
            //user_profile = getString("user_profile : ", true);

            System.out.println();

            if (email != null && password != null) {
                System.out.println(email + " " + password);
                rows.add(new Person(email, password));
            }
        }
        while (email != null && password != null);

        parameters.put("rows", rows);

        return new ViewData("Person", "insert", parameters);
    }


    /*
    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");


        int id = getInteger("id", true);
        String first_name = getString("first_name : ", true);
        String last_name = getString("last_name : ", true);
        String email = getString("email : ", true);
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
    */

    @Override
    public String toString() {
        return "Person View";
    }
}
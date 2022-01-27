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
        Integer choice;
        do {
            System.out.println("1. Login");
            System.out.println("2. Exit");

            choice = getInteger("Enter your choice : ", false);
        }
        while (choice == null || choice < 1 || choice > 2);

        if(choice == 1) {
            return selectGUI(modelData);
        }

        return new ViewData("Register", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {


        System.out.println("Login");

        String email, password;

        System.out.println("Fields to login:");
        email = getString("email : ", true);
        password = getString("password : ", true);


        ResultSet resultSet = modelData.resultSet;


        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                //email = resultSet.getString("email");
                //password = resultSet.getString("password");
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

        return new ViewData("Register", "");
    }


    Map<String, Object> getWhereParameters() throws Exception {
        //System.out.println("Filter conditions:");
        //Integer id = getInteger("id", true);
        //String first_name = getString("first_name : ", true);
        //String last_name = getString("last_name", true);
        String email = getString("email: ", true);
        String password = getString("password: ", true);
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


    @Override
    public String toString() {
        return "Person View";
    }
}
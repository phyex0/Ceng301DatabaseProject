package Views;

import Model.ModelData;
import java.util.HashMap;
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

        //return new ViewData("Register", "");
        System.exit(0);
        return null;
    }

    Map<String, Object> getWhereParameters() throws Exception {

        String email = getString("email: ", false);
        String password = getString("password: ", false);

        Map<String, Object> whereParameters = new HashMap<>();

        if (email != null) whereParameters.put("email", email);
        if (password != null) whereParameters.put("password", password);

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
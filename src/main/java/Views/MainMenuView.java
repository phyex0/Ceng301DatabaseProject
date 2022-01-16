package Views;

import Model.ModelData;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainMenuView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        Integer choice;
        do {
            System.out.println("1. Show all Users");
            System.out.println("2. Show User");
            System.out.println("3. Add a User");
            System.out.println("4. Update a User");
            System.out.println("5. Delete a User");
            //
            System.out.println("6. Show all Projects");
            System.out.println("7. Show Project");
            System.out.println("8. Add a Project");
            System.out.println("9. Update a Project");
            System.out.println("10. Delete a Project");
            //
            System.out.println("11. Show all Tasks");
            System.out.println("12. Show Task");
            System.out.println("13. Add a Task");
            System.out.println("14. Update a Task");
            System.out.println("15. Delete a Task");
            //
            System.out.println("16. Show all Assigned Tasks");
            System.out.println("17. Show Assigned Task");
            System.out.println("18. Add a Assigned Task");
            System.out.println("19. Update a Assigned Task");
            System.out.println("20. Delete a Assigned Task");
            //
            System.out.println("11. Show all Comments");
            System.out.println("12. Show Comment");
            System.out.println("13. Add a Comment");
            System.out.println("14. Update a Comment");
            System.out.println("15. Delete a Comment");

            System.out.println("6. Quit");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        }
        while (choice == null || choice < 1 || choice > 6);


        Map<String, Object> userInput = new HashMap<>();
        userInput.put("mainMenuChoice", choice);

        switch (choice.intValue()) {
            case 1:
                operationName = "select";
                break;
            case 2:
                operationName = "select.gui";
                break;
            case 3:
                operationName = "insert.gui";
                break;
            case 4:
                operationName = "update.gui";
                break;
            case 5:
                operationName = "delete.gui";
                break;
            default:
                return new ViewData(null, null);
        }

        return new ViewData("Person", operationName, new HashMap<>());
    }

    @Override
    public String toString() {
        return "Main Menu View";
    }

    @Override
    public Integer getInteger(String prompt, boolean allowNulls) throws ParseException {
        return ViewInterface.super.getInteger(prompt, allowNulls);
    }

    @Override
    public Double getDouble(String prompt, boolean allowNulls) throws ParseException {
        return ViewInterface.super.getDouble(prompt, allowNulls);
    }

    @Override
    public Boolean getBoolean(String prompt, boolean allowNulls) throws ParseException {
        return ViewInterface.super.getBoolean(prompt, allowNulls);
    }

    @Override
    public Date getDate(String prompt, boolean allowNulls) throws ParseException {
        return ViewInterface.super.getDate(prompt, allowNulls);
    }

    @Override
    public String getString(String prompt, boolean allowNulls) throws ParseException {
        return ViewInterface.super.getString(prompt, allowNulls);
    }
}

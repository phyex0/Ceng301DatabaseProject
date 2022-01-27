import Controllers.Controller;
import Model.*;
import Utility.DatabaseUtilities;
import Views.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        connectToDatabase();


        //1-register
        //2-login


        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>();
        router.put("Register", new Controller(new RegisterView(), new RegisterModel()));
        ViewData viewData;
        viewData = new ViewData("Register", "");


        Controller c = router.get(viewData.functionName);
        ModelData md = c.executeModel(viewData);
        viewData = c.getView(md, viewData.functionName, viewData.operationName);

        if (viewData.operationName == null)
            return;
        if (md.resultSet == null) {
            System.out.println("I'm null");
            return;
        }


        System.out.println("Test");


        //control

        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        router.put("Person", new Controller(new PersonView(), new PersonModel()));
        router.put("Project", new Controller(new ProjectView(), new ProjectModel()));
        router.put("Task", new Controller(new TaskView(), new TaskModel()));
        router.put("AssignedTask", new Controller(new AssignedTaskView(), new AssignedTaskModel()));
        router.put("Comment", new Controller(new CommentView(), new CommentModel()));

        viewData = new ViewData("MainMenu", "");
        do {
            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
        while (viewData.functionName != null);

        System.out.println();
        System.out.println();
        System.out.println("Program is ended...");


        // Disconnect from database
        disconnectFromDatabase();

    }

    public static void connectToDatabase() {
        //DatabaseUtilities.host = "DESKTOP-HFDS938";
        DatabaseUtilities.host = "MONSTER-PC:1433";
        DatabaseUtilities.databaseName = "TaskManagement";
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

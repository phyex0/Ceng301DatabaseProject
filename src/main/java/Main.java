import Controllers.Controller;
import Model.ModelData;
import Model.NopModel;
import Utility.DatabaseUtilities;
import Views.MainMenuView;
import Views.ViewData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        connectToDatabase();


        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>();
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        //router.put("Department", new Controller(new DepartmentView(), new DepartmentModel()));

        ViewData viewData = new ViewData("MainMenu", "");
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

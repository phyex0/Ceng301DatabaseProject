package Views;

import Entity.AssignedTask;
import Entity.Person;
import Entity.Project;
import Entity.Task;
import Model.ModelData;

import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignedTaskView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch (operationName) {
            case "select":
                return selectOperation(modelData);
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
                int source_user = resultSet.getInt("source_user");
                int destination_user = resultSet.getInt("destination_user");
                int task_id = resultSet.getInt("task_id");
                Date date = resultSet.getDate("assigned_date");


                // Display values
                System.out.print(id + "\t");
                System.out.print(source_user + "\t");
                System.out.print(destination_user + "\t");
                System.out.print(task_id + "\t");
                System.out.print(date + "\t");

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


        Integer id = getInteger("id : ", true);
        Integer source_user = getInteger("source_user", true);
        Integer destination_user = getInteger("destination_user", true);
        Integer task_id = getInteger("task_id : ", true);
        Date date = getDate("date : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) whereParameters.put("id", id);
        if (source_user != null) whereParameters.put("source_user", source_user);
        if (destination_user != null) whereParameters.put("destination_user", destination_user);
        if (task_id != null) whereParameters.put("task_id", task_id);
        if (date != null) whereParameters.put("date", date);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AssignedTask", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "id, source_user, destination_user, task_id, assigned_date");

        List<Object> rows = new ArrayList<>();


        Integer id;
        Integer source_user, destination_user, task_id;
        Date assigned_date;
        do {
            System.out.println("Fields to insert:");
            id = getInteger("id : ", true);
            source_user = getInteger("source_user : ", true);
            destination_user = getInteger("destination_user : ", true);
            task_id = getInteger("task_id : ", true);
            assigned_date = getDate("assigned_date : ", true);

            System.out.println();

            if (source_user != null && destination_user != null && task_id != null && assigned_date != null) {
                rows.add(new AssignedTask(id, source_user, destination_user, task_id, assigned_date));
            }
        }
        while (source_user != null && destination_user != null && task_id != null && assigned_date != null);

        parameters.put("rows", rows);

        return new ViewData("AssignedTask", "insert", parameters);
    }


    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");

        int id = getInteger("id", false);
        Integer source_user = getInteger("source_user : ", false);
        Integer destination_user = getInteger("destination_user : ", false);
        Integer task_id = getInteger("task_id : ", false);
        Date assigned_date = getDate("assigned_date", false);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();

        if (source_user != null) updateParameters.put("source_user", source_user);
        if (destination_user != null) updateParameters.put("destination_user", destination_user);
        if (task_id != null) updateParameters.put("task_id", task_id);
        if (assigned_date != null) updateParameters.put("assigned_date", assigned_date);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AssignedTask", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AssignedTask", "delete", parameters);
    }

    @Override
    public String toString() {
        return "AssignedTask View";
    }
}
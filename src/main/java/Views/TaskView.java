package Views;

import Entity.Person;
import Entity.Project;
import Entity.Task;
import Model.ModelData;
import Model.ModelInterface;

import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskView implements ViewInterface {

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
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date due_date = resultSet.getDate("due_date");
                String emergency = resultSet.getString("emergency");
                int section_status = resultSet.getInt("section_status");
                int project_id = resultSet.getInt("project_id");
                int user_id = resultSet.getInt("user_id");
                int root_task = resultSet.getInt("root_task");

                // Display values
                System.out.print(id + "\t");
                System.out.print(title + "\t");
                System.out.print(description + "\t");
                System.out.print(due_date + "\t");
                System.out.print(emergency + "\t");
                System.out.print(section_status + "\t");
                System.out.print(project_id + "\t");
                System.out.print(user_id + "\t");
                System.out.print(root_task + "\t");

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
        String title = getString("title : ", true);
        String description = getString("description : ", true);
        Date due_date = (Date) getDate("due_date : ", true);
        String emergency = getString("emergency", true);
        Integer section_status = getInteger("section_status", true);
        Integer project_id = getInteger("project_id", true);
        Integer user_id = getInteger("user_id : ", true);
        Integer root_task = getInteger("root_task : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) whereParameters.put("id", id);
        if (title != null) whereParameters.put("title", title);
        if (description != null) whereParameters.put("description", description);
        if (due_date != null) whereParameters.put("due_date", due_date);
        if (emergency != null) whereParameters.put("emergency", emergency);
        if (section_status != null) whereParameters.put("section_status", section_status);
        if (project_id != null) whereParameters.put("project_id", project_id);
        if (user_id != null) whereParameters.put("user_id", user_id);
        if (root_task != null) whereParameters.put("root_task", root_task);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Task", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "id, title, description, due_date, emergency, section_status, project_id, user_id, root_task");

        List<Object> rows = new ArrayList<>();


        Integer id;
        String title, description, emergency;
        Date due_date;
        Integer section_status, project_id, user_id, root_task;
        do {
            System.out.println("Fields to insert:");
            id = ModelInterface.getRandomId("dbo.Task");
            title = getString("title : ", true);
            description = getString("description : ", true);
            due_date = getDate("due_date : ", true);
            emergency = getString("emergency : ", true);
            section_status = getInteger("section_status : ", true);
            project_id = getInteger("project_id : ", true);
            user_id = getInteger("user_id : ", true);
            root_task = getInteger("root_task", true);


            System.out.println();

            if (title != null && description != null && due_date != null && emergency != null && section_status != null && project_id != null && user_id != null) {
                rows.add(new Task(id, title, description, due_date, emergency, section_status, project_id, user_id, root_task));
            }
        }
        while (title != null && description != null && due_date != null && emergency != null && section_status != null && project_id != null && user_id != null );

        parameters.put("rows", rows);

        return new ViewData("Task", "insert", parameters);
    }


    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");


        int id = getInteger("id", false);
        String title = getString("title : ", false);
        String description = getString("description : ", false);
        Date due_date = getDate("due_date : ", false);
        String emergency = getString("emergency : ", false);
        Integer section_status = getInteger("section_status : ", false);
        Integer project_id = getInteger("project_id : ", false);
        Integer user_id = getInteger("user_id : ", false);
        Integer root_task = getInteger("root_task", false);

        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();


        if (title != null) updateParameters.put("title", title);
        if (description != null) updateParameters.put("description", description);
        if (due_date != null) updateParameters.put("due_date", due_date);
        if (emergency != null) updateParameters.put("emergency", emergency);
        if (section_status != null) updateParameters.put("section_status", section_status);
        if (project_id != null) updateParameters.put("project_id", project_id);
        if (user_id != null) updateParameters.put("user_id", user_id);
        if (root_task != null) updateParameters.put("root_task", root_task);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Task", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Task", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Task View";
    }
}
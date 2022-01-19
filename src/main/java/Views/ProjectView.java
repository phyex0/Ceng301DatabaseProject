package Views;

import Entity.Person;
import Entity.Project;
import Model.ModelData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch(operationName) {
            case "select": return selectOperation(modelData);
            case "insert": return insertOperation(modelData);
            case "update": return updateOperation(modelData);
            case "delete": return deleteOperation(modelData);
            case "select.gui": return selectGUI(modelData);
            case "insert.gui": return insertGUI(modelData);
            case "update.gui": return updateGUI(modelData);
            case "delete.gui": return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int user_id = resultSet.getInt("user_id");


                // Display values
                System.out.print(id + "\t");
                System.out.print(name + "\t");
                System.out.print(user_id + "\t");
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
        Integer id = getInteger("id", true);
        String name = getString("name : ", true);
        Integer user_id = getInteger("id", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) whereParameters.put("id", id);
        if (name != null) whereParameters.put("name", name);
        if (user_id != null) whereParameters.put("user_id", user_id);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Project", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "id, name, user_id");

        List<Object> rows = new ArrayList<>();

        String name;
        Integer user_id;
        do
        {
            System.out.println("Fields to insert:");
            name = getString("name : ", true);
            user_id = getInteger("user_id : ", true);

            System.out.println();

            if (name != null && user_id != null) {
                rows.add(new Project(name, user_id));
            }
        }
        while (name != null && user_id != null );

        parameters.put("rows", rows);

        return new ViewData("Project", "insert", parameters);
    }


    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");

        String name = getString("name : ", true);
        Integer user_id = getInteger("user_id : ", true);

        System.out.println();


        Map<String, Object> updateParameters = new HashMap<>();
        if (name != null) updateParameters.put("name", name);
        if (user_id != null) updateParameters.put("user_id", user_id);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Project", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Project", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Project View";
    }
}

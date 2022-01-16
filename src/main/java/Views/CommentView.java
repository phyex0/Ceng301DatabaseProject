package Views;

import Entity.Comment;
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

public class CommentView implements ViewInterface {

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
                int task_id = resultSet.getInt("task_id");
                int user_id = resultSet.getInt("user_id");
                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");

                // Display values
                System.out.print(id + "\t");
                System.out.print(task_id + "\t");
                System.out.print(user_id + "\t");
                System.out.print(comment + "\t");
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
        Integer task_id = getInteger("task_id : ", true);
        Integer user_id = getInteger("user_id : ", true);
        String comment = getString("comment : ", true);
        Date date = getDate("date", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) whereParameters.put("id", id);
        if (task_id != null) whereParameters.put("task_id", task_id);
        if (user_id != null) whereParameters.put("user_id", user_id);
        if (comment != null) whereParameters.put("comment", comment);
        if (date != null) whereParameters.put("date", date);

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Comment", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "id, task_id, user_id, comment, date");

        List<Object> rows = new ArrayList<>();


        int id;
        Integer task_id, user_id;
        String comment;
        Date date;

        do
        {
            System.out.println("Fields to insert:");
            id = getInteger("id", false);
            task_id = getInteger("task_id : ", false);
            user_id = getInteger("user_id : ", false);
            comment = getString("comment : ", false);
            date = getDate("date : ", false);



            System.out.println();

            if (task_id != null && user_id != null && comment != null && date != null) {
                rows.add(new Comment(id, task_id, user_id, comment, date));
            }
        }
        while (task_id != null && user_id != null && comment != null && date != null);

        parameters.put("rows", rows);

        return new ViewData("Comment", "insert", parameters);
    }


    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");


        int id = getInteger("id", false);
        Integer task_id = getInteger("task_id : ", false);
        Integer user_id = getInteger("user_id : ", false);
        String comment = getString("comment : ", false);
        Date date = getDate("date : ", false);

        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();

        if (task_id != null) updateParameters.put("task_id", task_id);
        if (user_id != null) updateParameters.put("user_id", user_id);
        if (comment != null) updateParameters.put("comment", comment);
        if (date != null) updateParameters.put("date", date);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Comment", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Comment", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Comment View";
    }
}

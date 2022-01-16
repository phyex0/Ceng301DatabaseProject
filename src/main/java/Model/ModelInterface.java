package Model;

import Utility.DatabaseUtilities;
import Views.ViewData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;


public interface ModelInterface {

    abstract ResultSet select(Map<String, Object> whereParameters) throws Exception;

    abstract int insert(String fieldNames, List<Object> rows) throws Exception;

    abstract int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception;

    abstract int delete(Map<String, Object> whereParameters) throws Exception;

    static int getRandomId(String tableName) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT");
        sql.append("    id");
        sql.append("FROM " + tableName);

        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        ResultSet result = preparedStatement.executeQuery();

        HashSet<Integer> set = new HashSet<>();
        while (result.next())
            set.add(Integer.valueOf(result.getString("id")));

        Random random = new Random();
        int num = -1;
        while (true) {
            num = random.nextInt(Integer.MAX_VALUE);
            if (!set.contains(num))
                break;
        }

        return num;

    }

    default ModelData execute(ViewData viewData) throws Exception {
        if (viewData.viewParameters == null) {
            return new ModelData();
        }

        switch (viewData.operationName) {
            case "select": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = select(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }
            case "insert": {
                String fieldNames = (String) (viewData.viewParameters.get("fieldNames"));
                List<Object> rows = (List<Object>) (viewData.viewParameters.get("rows"));

                int recordCount = insert(fieldNames, rows);

                return new ModelData(viewData.functionName, recordCount);
            }
            case "update": {
                Map<String, Object> updateParameters = (Map<String, Object>) (viewData.viewParameters.get("updateParameters"));
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                int recordCount = update(updateParameters, whereParameters);

                return new ModelData(viewData.functionName, recordCount);
            }
            case "delete": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                int recordCount = delete(whereParameters);

                return new ModelData(viewData.functionName, recordCount);
            }
        }

        return new ModelData();
    }

}

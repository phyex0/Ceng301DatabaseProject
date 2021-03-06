package Views;

import Model.ModelData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public interface ViewInterface {
    public static final Scanner scanner = new Scanner(System.in);

    public default Integer getInteger(String prompt, boolean allowNulls) throws ParseException {
        Integer inputValue;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (allowNulls && input.trim().equals("")) {
                return null;
            }
            if (!allowNulls && input.trim().equals("")) {
                inputValue = null;
            } else {
                try {
                    inputValue = Integer.parseInt(input);
                } catch (Exception e) {
                    inputValue = null;
                }
            }
        }
        while (inputValue == null);

        return inputValue;
    }

    public default Double getDouble(String prompt, boolean allowNulls) throws ParseException {
        Double inputValue;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (allowNulls && input.trim().equals("")) {
                return null;
            }
            if (!allowNulls && input.trim().equals("")) {
                inputValue = null;
            } else {
                try {
                    inputValue = Double.parseDouble(input);
                } catch (Exception e) {
                    inputValue = null;
                }
            }
        }
        while (inputValue == null);

        return inputValue;
    }

    public default Boolean getBoolean(String prompt, boolean allowNulls) throws ParseException {
        Boolean inputValue;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (allowNulls && input.trim().equals("")) {
                return null;
            }
            if (!allowNulls && input.trim().equals("")) {
                inputValue = null;
            } else {
                try {
                    inputValue = Boolean.parseBoolean(input);
                } catch (Exception e) {
                    inputValue = null;
                }
            }
        }
        while (inputValue == null);

        return inputValue;
    }

    public default String getDate(String prompt, boolean allowNulls) throws ParseException {
        Date inputValue;
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (allowNulls && input.trim().equals("")) {
                return null;
            }
            if (!allowNulls && input.trim().equals("")) {
                inputValue = null;
            } else {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    inputValue = formatter.parse(input);

                } catch (Exception e) {
                    inputValue = null;
                }
            }
        }
        while (inputValue == null);

        return input;
    }

    public default String getString(String prompt, boolean allowNulls) throws ParseException {
        String inputValue;
        do {
            System.out.print(prompt);
            inputValue = scanner.nextLine();
            if (allowNulls && inputValue.trim().equals("")) {
                return null;
            }
            if (!allowNulls && inputValue.trim().equals("")) {
                inputValue = null;
            }

            if (prompt.contains("user_profile") && !(inputValue.equals("Manager") || inputValue.equals("Employee") || inputValue.equals("")))
                inputValue = null;
        }
        while (inputValue == null);

        return inputValue;
    }

    public default String getEmail(String prompt, boolean allowNulls) throws ParseException {
        String inputValue;
        do {
            System.out.print(prompt);
            inputValue = scanner.nextLine();

            if (allowNulls && inputValue.trim().equals(""))
                return null;

            if ((!Pattern.matches("^\\w+[@]+\\w+[.]+com$", inputValue)))
                inputValue = null;
        }
        while (inputValue == null);

        return inputValue;
    }


    abstract ViewData create(ModelData modelData, String functionName, String operationName) throws Exception;

}

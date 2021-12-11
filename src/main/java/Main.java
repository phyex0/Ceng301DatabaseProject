import Models.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DatabaseOperations dbo = new DatabaseOperations();

        ArrayList<User> users = new ArrayList<>();
        users = dbo.getUsers();

        if(users != null) {
            for(User user: users) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getBusinessEntityId());
            }
        }
    }
}

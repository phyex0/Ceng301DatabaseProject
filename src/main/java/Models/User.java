package Models;

public class User {
    //private int id;
    private String firstName;
    private String lastName;
    private int businessEntityId;
    public User(String firstName, String lastName, int businessEntityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessEntityId = businessEntityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBusinessEntityId() {
        return businessEntityId;
    }

    public void setBusinessEntityId(int businessEntityId) {
        this.businessEntityId = businessEntityId;
    }
}

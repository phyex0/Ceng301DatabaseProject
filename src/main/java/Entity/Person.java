package Entity;

public class Person {

    int id;
    String first_name;
    String last_name;
    String email;
    String password;
    String user_profile;

    public Person(String first_name, String last_name, String email, String password, String user_profile) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.user_profile = user_profile;
    }

    public Person(int id, String first_name, String last_name, String email, String password, String user_profile) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.user_profile = user_profile;
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "id":
                return id;
            case "first_name":
                return first_name;
            case "last_name":
                return last_name;
            case "email":
                return email;
            case "password":
                return password;
            case "user_profile":
                return user_profile;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_profile=" + user_profile +
                '}';
    }
}

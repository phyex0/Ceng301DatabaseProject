package Entity;

public class Project {

    int id;
    String name;
    int user_id;

    public Project() {
    }

    public Project(int id, String name, int user_id) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "id":
                return id;
            case "name":
                return name;
            case "user_id":
                return user_id;
            default:
                return null;
        }
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}

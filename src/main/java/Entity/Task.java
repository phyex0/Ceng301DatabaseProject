package Entity;

import java.util.Date;

public class Task {

    int id;
    String title;
    String description;
    Date due_date;
    String emergency;
    int section_status;
    int project_id;
    int user_id;
    int root_task;

    public Task() {
    }

    public Task(int id, String title, String description, Date due_date, String emergency, int section_status, int project_id, int user_id, int root_task) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.emergency = emergency;
        this.section_status = section_status;
        this.project_id = project_id;
        this.user_id = user_id;
        this.root_task = root_task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public int getSection_status() {
        return section_status;
    }

    public void setSection_status(int section_status) {
        this.section_status = section_status;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoot_task() {
        return root_task;
    }

    public void setRoot_task(int root_task) {
        this.root_task = root_task;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "id":
                return id;
            case "title":
                return title;
            case "description":
                return description;
            case "due_date":
                return due_date;
            case "emergency":
                return emergency;
            case "section_status":
                return section_status;
            case "project_id":
                return project_id;
            case "user_id":
                return user_id;
            case "root_task":
                return root_task;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", due_date=" + due_date +
                ", emergency='" + emergency + '\'' +
                ", section_status=" + section_status +
                ", project_id=" + project_id +
                ", user_id=" + user_id +
                ", root_task=" + root_task +
                '}';
    }
}

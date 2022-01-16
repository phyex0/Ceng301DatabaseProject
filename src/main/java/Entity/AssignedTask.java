package Entity;

import java.sql.Date;

public class AssignedTask {

    int id;
    int source_user;
    int destination_user;
    int task_id;
    Date assigned_date;

    public AssignedTask() {
    }

    public AssignedTask(int id, int source_user, int destination_user, int task_id, Date assigned_date) {
        this.id = id;
        this.source_user = source_user;
        this.destination_user = destination_user;
        this.task_id = task_id;
        this.assigned_date = assigned_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource_user() {
        return source_user;
    }

    public void setSource_user(int source_user) {
        this.source_user = source_user;
    }

    public int getDestination_user() {
        return destination_user;
    }

    public void setDestination_user(int destination_user) {
        this.destination_user = destination_user;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public Date getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(Date assigned_date) {
        this.assigned_date = assigned_date;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "id":
                return id;
            case "source_user":
                return source_user;
            case "destination_user":
                return destination_user;
            case "task_id":
                return task_id;
            case "assigned_date":
                return assigned_date;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "AssignedTask{" +
                "id=" + id +
                ", source_user=" + source_user +
                ", destination_user=" + destination_user +
                ", task_id=" + task_id +
                ", assigned_date=" + assigned_date +
                '}';
    }
}

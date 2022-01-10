package Repositories;

import java.sql.Date;

public class Comment {

    int id;
    int task_id;
    int user_id;
    String comment;
    Date date;

    public Comment() {
    }

    public Comment(int id, int task_id, int user_id, String comment, Date date) {
        this.id = id;
        this.task_id = task_id;
        this.user_id = user_id;
        this.comment = comment;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "id":
                return id;
            case "task_id":
                return task_id;
            case "user_id":
                return user_id;
            case "comment":
                return comment;
            case "date":
                return date;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", user_id=" + user_id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}

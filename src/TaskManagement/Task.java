package TaskManagement;

import java.io.Serializable;


public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String taskTitle;
    private String task;
    private String createdDate;
    private boolean isdone;
    private String toBeCompleted;

    Task(int id, String title, String description, String dateCreated, boolean isDone){
        this.id=id;
        this.taskTitle=title;
        this.task=description;
        this.createdDate=dateCreated;
        this.isdone=isDone;
        
    }

    @Override
    public String toString(){
        return "Task " + id + ": " + this.taskTitle + "\n" + this.task + ".\nCreated: "+createdDate;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTask() {
        return task;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getToBeCompleted() {
        return toBeCompleted;
    }

    public boolean isDone() {

        return isdone;
    }

    // setters

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTask(String task) {
        this.task = task;
    }
}

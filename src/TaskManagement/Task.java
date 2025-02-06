package TaskManagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private int id;
    private String taskTitle;
    private String task;
    private LocalDate createdDate;
    private boolean isdone;
    private LocalDate toBeCompleted;

    Task(int id, String title, String description, LocalDate dateCreated, boolean isDone, LocalDate toBeCompleted){
        this.id=id;
        this.taskTitle=title;
        this.task=description;
        this.createdDate=dateCreated;
        this.isdone=isDone;
        this.toBeCompleted=toBeCompleted;
    }

    public String toString(){
        return "Task " + id + ": " + this.task + ".\nCreated: "+createdDate;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getToBeCompleted() {
        return toBeCompleted;
    }

    public boolean isDone() {
        return isdone;
    }
}

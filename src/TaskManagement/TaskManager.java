package TaskManagement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager{
    private ArrayList<Task> tasks; 
    private static final String File_Name = "Mytasks.txt";



    public void createTask(String title, String description, LocalDate createdDate, boolean isDone){
       if(title!="" && description!=""){
            int id = tasks.size() + 1;
            new Task(id, title, description, createdDate, isDone, createdDate);
            saveTask();
       }
    }

    public Task getTask(int id){
        Task task = new Task(id, null, null, null, false, null);
        if (id > tasks.size()) {
            System.out.println("Invalid id.");
        } else {
            tasks.get(id);
        }
        return task;
    }

    public Task updateTask(int id,String title, String description,LocalDate toBeCompleted){
        Task updatedTask = new Task(id, title, description, toBeCompleted, false, toBeCompleted);
        try {
            if(tasks.size()<id){
                System.out.println("Invalid id.");
            } else {
                Task newTask = new Task(id, title, description, null, false, toBeCompleted);
                updatedTask=tasks.set(id,newTask);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        saveTask();
       return updatedTask;
    }

    public void deleteTask(int id){
        tasks.remove(id);
        saveTask();
        System.err.print("Task deleted from cache.");
    }

    private void saveTask(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File_Name))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}

package TaskManagement;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;


public class TaskManager{
    private ArrayList<Task> tasks; 
    private static final String File_Name = "Mytasks.dat";


    TaskManager(){
        this.tasks = loadTasks();
    }

    public void createTask(String title, String description, String createdDate, boolean isDone){
      
        if(title!="" && description!=""){
            int id = tasks.size() + 1;
            tasks.add(new Task(id, title, description, createdDate, isDone));      
            saveTask();
            System.out.println("Task successfully added.");
       } else {
        System.out.println("Title is empty:");
        System.out.println("Description is empty:");
       }
    }

    public Task getTask(int id){
        Task task = new Task(id, null, null, null, false);
        if (id > tasks.size()) {
            System.out.println("Invalid id.");
        } else {
            tasks.get(id);
        }
        return task;
    }

    public Task updateTask(int id,String title, String description,String toBeCompleted){
        Task updatedTask = new Task(id, title, description, toBeCompleted, false);
        try {
            if(tasks.size()<id){
                System.out.println("Invalid id.");
            } else {
                Task newTask = new Task(id, title, description, null, false);
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

    public void myTasks(){
        if(tasks.isEmpty()){
            System.out.println("You currently have no task.");
        } else {
            tasks.forEach(task -> System.out.println(task));
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Task> loadTasks(){
        File file = new File(File_Name);
        if(!file.exists()) return new ArrayList<>();

        ArrayList<Task> tasks = new ArrayList<>();

        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file))) {
            tasks = (ArrayList<Task>)oos.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

        return tasks;
    } 
}

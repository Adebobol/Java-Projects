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

    public void lookupTask(int id){
        try {
            // int taskSize=tasks.size();
            for(Task task: tasks) {
                if(task.getId()==id){
                    System.out.println(task);
                }
            }      
        } catch (Exception e) {
            System.out.println("Invalid id.");
        }
    }

    public Task updateTask(int id,String title, String description){
        int twickId = id-1;
        Task uTask = tasks.get(twickId);
      
        if(!title.isBlank()){
            uTask.setTaskTitle(title);
        } else if(!description.isBlank()){
            uTask.setTask(description);
        }
       saveTask();
       return uTask;
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
            tasks.forEach(task -> System.out.println(task+"\n"));
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

package TaskManagement;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager{
    ArrayList<Task> tasks; 



    public void createTask(String title, String description, LocalDate createdDate, boolean isDone){
        if(title==" " || description==" "){
            System.out.println("Title can't be empty.");
        }
        int currentSize = tasks.size();
        int id = currentSize + 1;
        tasks.add(new Task(id, title, description, createdDate, isDone, createdDate));
    }

    public void getTask(int id){
        tasks.get(id);
    }

    public String updateTask(int id){
        
        return "";  
    }

    public String deleteTask(){
        return "";
    }
}

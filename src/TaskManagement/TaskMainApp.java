package TaskManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskMainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager task_manager = new TaskManager();

        // app variables
        boolean open = true;
        String title = "";
        String description = "";
        

        // while loop to keep app running
        while(open){
            System.out.println("*My Task Manager*");
            System.out.println("1) Add Task");
            System.out.println("2) List Tasks");
            System.out.println("3) Update Task");
            System.out.println("4) Delete Task");
            System.out.println("5) Look up a Task");
            System.out.println("6) Exit");
            
            // accept response
            int response = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            // switch statement to perform based on your response
            switch(response){
                case 1 -> {
                    System.out.println("Add Task");
                    System.out.println("Enter task title: ");
                    title = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    description = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu MMMM d");
                    String presentDate = dateTime.format(formatter);
                    
                    task_manager.createTask(title, description, presentDate,false);
                    break;
                }

                case 2 -> task_manager.myTasks();

                case 3 -> {
                    char res = ' ';
                    
                    System.out.println("What do you want to update:");
                    int id = scanner.nextInt();
                    System.out.println("Enter id of task to be updated: ");
                    
                    System.out.println("1) Title");
                    System.out.println("2) Description");
                    res = scanner.next().charAt(0);
                    if(res=='1'){
                        task_manager.getTask(id);
                    }
                }
            }

        }

        scanner.close();
    }
}

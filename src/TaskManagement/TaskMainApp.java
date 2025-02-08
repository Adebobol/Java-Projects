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
                    // String res = "";
                    String utitle = "";
                    String udescription = "";
                    
                    System.out.println("Id of task to be updated: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What do you want to update(title/description): ");
                    String res = scanner.nextLine();
                    if(res.equals("title")){
                        System.out.println("Enter new title: ");
                        utitle = scanner.nextLine();
                    } else if(res.equals("description")) {
                        System.out.println("Enter new description: ");
                        udescription = scanner.nextLine();
                    } else{
                        System.out.println("Invalid input");
                        break;
                    }
                    
                    task_manager.updateTask(id, utitle, udescription);

                }

                case 4 -> {
                    System.out.println("Enter id of task: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    task_manager.deleteTask(id);
                }
              

                case 5 -> {
                    System.out.println("Enter task id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    task_manager.lookupTask(id);
                    // scanner.nextLine();
                }

                case 6 -> {
                    String exitRes = "";
                    System.out.println("Are you sure you want to exit(yes/no): ");
                    exitRes = scanner.nextLine();
                    if(exitRes.equals("yes")){
                        open=false;
                    } else if(exitRes.equals("no")){
                        continue;
                    }
                }
            }

        }

        scanner.close();
    }
}

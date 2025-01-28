package ConsoleBased;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmClock {
    public static void main(String[] args) {
        // Welcome to the Alarm Program!
        // Enter the time for the alarm (HH:mm): 08:30
        // Alarm set for 08:30. Waiting...

        // [At 08:30]
        // Beep! Beep! Beep! Alarm ringing!

        Scanner scanner =  new Scanner(System.in);

        // Define time variables
        int d = 0;
        int MMMM = 0;
        int uuuu = 0;
        int HH = 0;
        int mm = 0;
   
        // variable indicating alarm is turned on or off
        boolean on = true;

        // response variable for type of alram
        String response = "";

        // Opening program for my alarm.
        System.out.println("Welcome to the Alarm Program!");
        System.out.println("Set time alone. Use format(HH:mm): 08:30\nPress 1: ");
        System.out.println();
        System.out.println("Set date and time. Use format(day, month year. HH:mm)\nPress 2: ");
        response = scanner.next();

        // switch statement to choose alarm type
        switch(response){
            case "1":
            // if it's only for the time
                System.out.println("Enter HH: ");
                HH = scanner.nextInt();
                System.out.println("Enter mm: ");
                mm = scanner.nextInt();             
                break;
            case "2":
            // if it's for date and time
                System.out.println("Enter HH: ");
                HH = scanner.nextInt();
                System.out.println("Enter mm: ");
                mm = scanner.nextInt();
                System.out.println("Enter day: ");
                d = scanner.nextInt();
                System.out.println("Enter month: ");
                MMMM = scanner.nextInt();
                System.out.println("Enter year: ");
                uuuu = scanner.nextInt();
                break;
            default:
                System.out.println("Wrong inputs.");
        }

        while(on){
          Timer timer = new Timer();
          TimerTask task = new TimerTask() {


            @Override
            public void run() {
              

           
            }
            
          };
        }

        scanner.close();

    }
}
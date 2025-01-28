package ConsoleBased;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        // Welcome to the Alarm Program!
        // Enter the time for the alarm (HH:mm): 08:30
        // Alarm set for 08:30. Waiting...

        // [At 08:30]
        // Beep! Beep! Beep! Alarm ringing!

        Scanner scanner =  new Scanner(System.in);

        // present factors
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d,MMMM uuuu.");
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, MMMM uuuu. HH:mm");
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String presentDate = date.format(formatter);
        System.out.print(presentDate);
        System.out.println();
        

        // Define time variables
        String d = "";
        String MMMM = "";
        String uuuu = "";
        String HH = "";
        String mm = "";

        // response variable for switch
        String response = "";

        System.out.println("Welcome to the Alarm Program!");
        System.out.println("Set time alone. Use format(HH:mm): 08:30\nPress 1: ");
        System.out.println();
        System.out.println("Set date and time. Use format(day, month year. HH:mm)\nPress 2: ");
        response = scanner.next();

        switch(response){
            case "1":
                System.out.println("Enter HH: ");
                HH = scanner.next();
                System.out.println("Enter mm: ");
                mm = scanner.next();
                // Alarm set for 08:30. Waiting...
                System.out.printf("Alarm set for: %s %s:%s\nwaiting...", presentDate,HH,mm);
                break;
            case "2":
                System.out.println("Enter HH: ");
                HH = scanner.next();
                System.out.println("Enter mm: ");
                mm = scanner.next();
                System.out.println("Enter day: ");
                d = scanner.next();
                System.out.println("Enter month: ");
                MMMM = scanner.next();
                System.out.println("Enter year: ");
                uuuu = scanner.next();
                System.out.printf("Alarm for: %s,%s %s. %s:%s",d,MMMM,uuuu,HH,mm);
                break;
            default:
                System.out.println("Wrong inputs.");
        }

        scanner.close();

    }
}
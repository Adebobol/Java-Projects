package ConsoleBased;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        // present date
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d,MMMM uuuu.");
        String presentDate = date.format(dateFormatter);
        // present date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d,MMMM uuuu. HH:mm");
        String presentDateTime = dateTime.format(dateTimeFormatter);
        System.out.println(presentDateTime);
        System.out.println();
        

        // Define time variables
        String d = "";
        String MMMM = "";
        String uuuu = "";
        String HH = "";
        String mm = "";
        String setAlarm = "";
   
        boolean on = true;

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
                setAlarm = presentDate+" "+HH+":"+mm;
                System.out.println(setAlarm);
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
                setAlarm = d+","+MMMM+ " " +uuuu+". " + HH+":"+mm;
                System.out.println(setAlarm);
                System.out.printf("Alarm for: %s,%s %s. %s:%s",d,MMMM,uuuu,HH,mm);
                break;
            default:
                System.out.println("Wrong inputs.");
        }

        while(on){
          Timer timer = new Timer();
          TimerTask task = new TimerTask() {


            @Override
            public void run() {
                String presentDateTime ="";
                // present date and time
            LocalDateTime dateTime11 = LocalDateTime.now();
            DateTimeFormatter dateTime11Formatter = DateTimeFormatter.ofPattern("d,MMMM uuuu. HH:mm");
            presentDateTime = dateTime11.format(dateTime11Formatter);

            System.out.println(presentDateTime);
                System.out.println(setAlarm);

            if(presentDate.equals(setAlarm)) {
                System.out.println("Alarm rings!!!");
            }
            }
            
          };
        }

        scanner.close();

    }
}
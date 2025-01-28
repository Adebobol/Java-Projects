package ConsoleBased;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

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
        

        boolean on = true;
        // Define time variables
        String d = "00";
        String MMMM = "January";
        String uuuu = "2000";
        String HH = "12";
        String mm = "00";

        // response variable for switch
        String response = "";

        // System.out.print("Enter hour: ");
        // HH = scanner.nextLine();
        // System.out.println("Enter minute: ");
        // mm = scanner.nextLine();
        // System.out.println("Enter day: ");
        // d = scanner.nextLine();
        // System.out.println("Enter month: ");
        // MMMM = scanner.nextLine();
        // System.out.println("Enter year: ");
        // uuuu = scanner.nextLine();

        System.out.println(HH);
        System.out.println(d);
        System.out.println(mm);
        System.out.println(uuuu);
        System.out.println(MMMM);
        
        // if loop to check if day-month-year is empty
        if(d.isEmpty() && MMMM.isEmpty()  && uuuu.isEmpty()){
            System.out.printf("%s %s:%s", presentDate,HH,mm);
        } else {
            System.out.printf("Alarm set to: %s, %s %s. %s:%s",d,MMMM,uuuu,HH,mm);
        }

        System.out.print("Set time alone. Press 1: ");
        System.out.println("set date and time. Press 2: ");
        response = scanner.next();

        switch(response){
            case "1":
                System.out.print("Enter hour: ");
                HH = scanner.nextLine();
                System.out.println("Enter minute: ");
                mm = scanner.nextLine();
                break;
            case "2":
                System.out.println("Enter day: ");
                d = scanner.nextLine();
                System.out.println("Enter month: ");
                MMMM = scanner.nextLine();
                System.out.println("Enter year: ");
                uuuu = scanner.nextLine();
                break;
        }



        scanner.close();

    }
}
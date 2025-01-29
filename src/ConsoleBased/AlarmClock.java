package ConsoleBased;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock {
    public static void main(String[] args) {
        // Welcome to the Alarm Program!
        // Enter the time for the alarm (HH:mm): 08:30
        // Alarm set for 08:30. Waiting...

        // [At 08:30]
        // Beep! Beep! Beep! Alarm ringing!

        Scanner scanner =  new Scanner(System.in);

        // checking file to play sound
        
        String filepath = "C:\\Users\\OXYMO\\Java Tut\\main\\src\\audio\\13 Break Or Make Me - (SongsLover.com).wav";
        File file = new File(filepath);   

        
        // Define time variables
        int d = 29;
        int MMMM = 01;
        int uuuu = 2025;
        int HH = 12;
        int mm = 00;
        // LocalDateTime alarm = LocalDateTime.now();
        AtomicReference<LocalDateTime> alarm = new AtomicReference<>(LocalDateTime.now());
   
        // variable indicating alarm is turned on or off

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
                alarm.set(LocalDateTime.of(uuuu,MMMM, d ,HH,mm));
                System.out.println(alarm);
                System.out.println();
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
                alarm.set(LocalDateTime.of(uuuu,MMMM, d ,HH,mm));
                System.out.println(alarm);
                System.out.println();
                break;
            default:
                System.out.println("Wrong inputs.");
        }

    

        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            


        @Override
        public void run() {
            
            LocalDateTime dtnow = LocalDateTime.now();
            // System.out.println(dtnow);
              
            if(dtnow.withNano(0).equals(alarm.get().withNano(0))){
                System.out.println("Alarm rings!!!!");

                try(AudioInputStream audiostream = AudioSystem.getAudioInputStream(file)) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(audiostream);
                    clip.start();
                } catch(IOException | UnsupportedAudioFileException | LineUnavailableException e){
                    System.out.println("Error playinf sound " + e.getMessage());
                }
            }
           
        }
            
        };

        timer.schedule(task, 0,1000);
        

        scanner.close();

    }
}
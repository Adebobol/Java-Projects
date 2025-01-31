package USSD;

import java.util.Scanner;

public class Ussd {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // necessary variables
        String ussdCode = "";
        boolean running = false;
        String serviceResponse = "";



        // try-catch
        try {
            System.out.println("Ussd: ");
            ussdCode = scanner.nextLine();
            System.out.println(ussdCode);
            if(ussdCode.equals("*996#")){
                running = true;
            } else {
                System.out.println("Invalid code.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        do{
            System.err.println("Eazybanking");
            System.out.println("Open Account");
            System.out.println("1>Airtime");
            System.out.println("2>Data");
            System.out.println("4>Transfer");
            System.out.println("5>Check Balance");

            System.out.println("Response: ");
            serviceResponse= scanner.nextLine();

            switch(serviceResponse){
                case "1"->{

                }
                
            }
        }while(running);

        scanner.close();

   }
    
}

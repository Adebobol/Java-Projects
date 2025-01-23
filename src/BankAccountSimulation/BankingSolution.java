package BankAccountSimulation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Bank{
    String nameOfBank;
    static int numberOfUsers;

    
    Bank(String nameOfBank){
        this.nameOfBank = nameOfBank;
    }

    static Long generateAccountNumber(){
        Random random = new Random();
        // Generate a random 10-digit number
        // long tenDigitNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        Long tenDigitNumber = 2400000000L + (long)(random.nextDouble() * 2500000000L);
        // System.out.println("Random 10-digit number: " + tenDigitNumber);
        return tenDigitNumber;

    }


    // getters
    public String getNameOfBank() {
        return nameOfBank;
    }


}

class BankAccount extends Bank {
    Bank bank;
    Long accountNumber;
    String accountName;
    String accountType;
    String holderNIN;
    double accountBalance;

    BankAccount(Long accountNumber, String nameOfBank,String name, String accountType,String NIN){
        super(nameOfBank);
        this.accountType = accountType;
        this.accountName= name;
        this.holderNIN=NIN;
        this.accountNumber=accountNumber;
    }

    // getters
    public String getAccountName() {
        return accountName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    void deposit(double amount, Long receiverAccount){
        if(amount > 0 && receiverAccount.equals(accountNumber)){
            accountBalance +=amount;
            System.out.printf("Account number %s deposited: %s.\nNew balance %f",accountNumber,amount,accountBalance);
        } else {
            System.out.printf("You can't deposit %f", amount);
        }
    }

    void checkBalance(){
        System.out.printf("Account balance: %.2f",accountBalance);
    }

    void withdrawal(double amount){
        if(amount > 0 && amount<= accountBalance ){
            accountBalance -= amount;
            System.out.printf("A withdrawal of %f occured.\n Account balance: %af",amount,accountBalance);
        } else if(amount < accountBalance) {
            System.out.print("Insufficient Funds.");
        } else {
            System.out.print("Inalid input.");
        }
    }

    void transfer(){}
}


public class BankingSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response;
        
        String bankName ="";
        String name="";
        String accountType="";
        String ninNumber="";

        boolean running = true;
        Long accountNumber = 0L;

        BankAccount newAccount = new BankAccount(accountNumber, bankName, name, accountType, ninNumber);

        ArrayList<Bank> accounts = new ArrayList<>();
        ArrayList<String> NIN = new ArrayList<>();

        while(running){
            System.out.println("Welcome To Anifowese Bank");
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Check Balance");
            System.out.print("Enter response: ");
            response= scanner.next();


            switch(response){
                case "1":
                // response prompts
                    System.out.print("Enter bank name: ");
                    bankName = scanner.next();
                    System.out.println("Enter your name: ");
                    name = scanner.next();
                    System.out.println("Enter type of account you want to create (current or savings): ");
                    accountType = scanner.next();
                    System.out.println("Enter your NIN: ");
                    ninNumber = scanner.next();
                    scanner.nextLine();
                // checking if NIN already exists throug
                    if(!NIN.contains(ninNumber)) {
                        NIN.add(ninNumber);
                        accountNumber = Bank.generateAccountNumber();
                        newAccount = new BankAccount(accountNumber,bankName, name, accountType,ninNumber);
                        accounts.add(newAccount);
                        System.out.printf("Account successfully created.\nYour account number is: %d",accountNumber);
                        System.out.println();
                    } else {
                        System.out.printf("Account number: %d already exists.",accountNumber);
                        System.out.println();
                    }
                    break;
                case "2":
                    System.out.println("Amount to deposit");
                    double amount = scanner.nextDouble();
                    newAccount.deposit(amount, accountNumber);
                    System.out.println();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid response!");
            }
        }

      

        scanner.close();
        
    }
}

package BankAccountSimulation;

import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
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

    void transfer(double amount, Long reciverAccount){
        if (amount > 0 && amount < accountBalance && reciverAccount != accountNumber) {
            accountBalance -= amount;
            // System.out.printf("Transfer of $ %d has been made to $d.\ntRANSFER SUCCESSFUL",amount, reciverAccount);
            System.out.println("Transfer successful.");
        } else if(amount <=0){
            System.out.printf("You can't make transfer of %d",amount);
        } else if(amount>=accountBalance) {
            System.out.println("Insufficient funds!!!");
        } else if(reciverAccount == accountNumber) {
            System.err.println("You can't make transfer to your account.");
        } else{
            System.out.println("System Error.");
        }
    }
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

        ArrayList<BankAccount> accounts = new ArrayList<>();
        ArrayList<String> NIN = new ArrayList<>();

    
        try{
            
        while(running){
            System.out.println("Welcome To Anifowese Bank");
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Check Balance");
            System.out.println("5) Transfer");
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
                    double amountToDeposit = scanner.nextDouble();
                    newAccount.deposit(amountToDeposit, accountNumber);
                    System.out.println();
                    break;
                case "3":
                    break;
                case "4":
                    newAccount.checkBalance();
                    break;
                case "5":
                    System.out.println("Enter amount to be transferred: ");
                    double amountToTransfer = scanner.nextDouble();
                    System.out.println("Enter account number of reciever: ");
                    Long recieverAccount = scanner.nextLong();

                    if(accounts.size()==0){
                        System.out.println("Issues!");
                        break;
                    }
                    

                    for(BankAccount account: accounts){
                        if(account.accountNumber.equals(recieverAccount)){
                            newAccount.transfer(amountToTransfer, recieverAccount);
                        } else{
                            System.out.println("Invalid reciever account number.");
                        }
                    }
                    break;
                default:
                    running = false;
                    System.out.println("Invalid response!");
            }
        } 
    
        } catch(IllegalFormatConversionException e){
            System.out.println();

        }

      

        scanner.close();
        
    }
}

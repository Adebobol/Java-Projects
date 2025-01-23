package BankAccountSimulation;

class Bank{
    String nameOfBank;
    static int numberOfUsers;

    
    Bank(String nameOfBank){
        this.nameOfBank = nameOfBank;
    }

    // getters
    public String getNameOfBank() {
        return nameOfBank;
    }
    

}

class BankAccount extends Bank {
    Bank bank;
    String accountNumber;
    String accountName;
    String accountType;

    BankAccount(String nameOfBank,String accountNumber, String accountName, String accountType){
        super(nameOfBank);
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.accountType = accountType;
        // this.bank = new Bank(bankName); 
    }

    // getters
    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    // banking operations
    void deposit(){}

    void checkBalance(){}

    void withdrawal(){}

    void transfer(){}
}


public class BankingSolution {
    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount("Anifowose","Adepoju Adebobola Kehinde", "2450327674","Savings");

        System.out.println(bankAccount1.accountName);
        System.out.println();
        System.out.println(bankAccount1.accountNumber);
        System.out.println();
        System.out.println(bankAccount1.nameOfBank);
        System.out.println();
        System.out.println(bankAccount1.accountType);
        
    }
}

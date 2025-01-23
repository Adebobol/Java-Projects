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
    double accountBalance;

    BankAccount(String nameOfBank,String accountNumber, String accountName, String accountType,double initialBalance){
        super(nameOfBank);
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.accountType = accountType;
        this.accountBalance = initialBalance;
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
    void deposit(double amount, String receiverAccount){
        if(amount > 0 && receiverAccount.equals(accountNumber)){
            accountBalance +=amount;
            System.out.printf("Account number %s deposited: %s",accountName,amount);
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

        BankAccount bankAccount1 = new BankAccount("Anifowose","Adepoju Adebobola Kehinde", "2450327674","Savings",0.00);

        System.out.println(bankAccount1.accountName);
        System.out.println();
        System.out.println(bankAccount1.accountNumber);
        System.out.println();
        System.out.println(bankAccount1.nameOfBank);
        System.out.println();
        System.out.println(bankAccount1.accountType);
        System.out.println();
        bankAccount1.checkBalance();
        
    }
}

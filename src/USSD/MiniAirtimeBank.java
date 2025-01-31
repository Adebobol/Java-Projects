package USSD;
import USSD.UssdCommand;

class MiniAirtimeBank implements UssdCommand{
    private double balance;
    private String name;
    
    MiniAirtimeBank(double balance, String name){
        this.balance=balance;
        this.name = name;
    }

    @Override
    public double buyAirtime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buyAirtime'");
    }

    @Override
    public double sendAirtime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendAirtime'");
    }

}
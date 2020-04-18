package model.physicalobjects;
import model.physicalobjects.Store;
import model.salemodel.Payment;

public class Register {
    Store store;
    private static double balance;

    public Register(Store store){
        this.store = store;
    }

    public void enterPayment(Payment payment){
        setBalance(balance + payment.getAmountPayed());
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

}
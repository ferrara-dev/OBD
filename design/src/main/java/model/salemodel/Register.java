package model.salemodel;

import model.Store;

public class Register {
    Store store;
    private double balance;

    public Register(Store store){
        this.store = store;
    }

    public void processPayment(Payment payment){
        double amountPayed = payment.getAmountPayed();
        payment.getSaleDetail().updateRunningTotal((-1)*amountPayed);
    }

    public double getBalance(){
        return balance;
    }

}

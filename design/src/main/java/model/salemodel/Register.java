package model.salemodel;

public class Register {
    private double balance;


    public Register(){
    }

    public double processPayment(SaleDetail saleDetail, double amount){
        double rest = amount - saleDetail.getRunningTotal();
        balance += amount;
        return rest;
    }

    public double getBalance(){
        return balance;
    }

    public void printReciept(SaleDetail saleDetail){

    }
}

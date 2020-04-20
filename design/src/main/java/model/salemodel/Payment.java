package model.salemodel;

/**
 * Class representing a payment of items
 */
public class Payment {
    private double amountPayed;
    private final String currency = "kronor";

    public Payment(){

    }

    public void setAmountPayed(double amountPayed){
        this.amountPayed = amountPayed;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

}

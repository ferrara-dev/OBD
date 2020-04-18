package model.salemodel;

/**
 * Class representing a payment of items
 */
public class Payment {
    private double priceToPay;
    private double amountPayed;
    private final String currency = "kronor";

    public Payment(double priceToPay, double amountPayed){
        this.priceToPay = priceToPay;
        this.amountPayed = amountPayed;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

}

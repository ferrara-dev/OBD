package model.salemodel;

/**
 * Class representing a payment
 */
public class Payment {
    private double amountPayed;
    private SaleDetail saleDetail;
    private final String currency = "kronor";

    public Payment(SaleDetail saleDetail, double amountPayed){
        this.saleDetail = saleDetail;
        this.amountPayed = amountPayed;
    }

    public double getPriceToPay() {
        return saleDetail.getRunningTotal();
    }

    public SaleDetail getSaleDetail() {
        return saleDetail;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

}

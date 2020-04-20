package model.salemodel;


import java.util.ArrayList;
import java.util.List;

public class Sale {
    private SaleDetail saleDetail;
    private Cart cart;
    private Cost cost;
    private Payment salePayment;
    private double runningTotal = 0;
    private double cashBack = 0;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */

    public Sale() {

    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public Payment getSalePayment() {
        return salePayment;
    }

    public void setSalePayment(Payment salePayment) {
        this.salePayment = salePayment;
    }

    public Cost getCost() {
        return cost;
    }

    public void updateCost() {
        cost.updateCost(this);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void createDefault(){
        this.cart = new Cart(new ArrayList<>());
        this.cost = new Cost();
        this.saleDetail = new SaleDetail();
        saleDetail.createDefault();
    }

    /**
     * Method used to initiate fields to default values in a newly started sale
     */
    public SaleDetail getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(SaleDetail saleDetail) {
        this.saleDetail = saleDetail;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public String saleDetailAsString() {
        StringBuilder sb = new StringBuilder(saleDetail.asText());
        sb.append("\n");
        sb.append("---------------------\n");
        sb.append("running total : " + runningTotal + "\n");
        return sb.toString();
    }

}

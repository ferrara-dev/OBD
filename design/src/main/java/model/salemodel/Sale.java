package model.salemodel;


public class Sale {
    private SaleDetail saleDetail;
    private double runningTotal = 0;
    private double totalCost = 0;
    private double totalVAT = 0;
    private double cashBack = 0;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */

    public Sale() {

    }

    public void createDefault(){
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

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }


    public double getTotalVAT() {
        return totalVAT;
    }



    public double getRunningTotal() {
        return runningTotal;
    }

    public double getCashBack() {
        return cashBack;
    }

    public double getTotalCost() {
        return totalCost;
    }


    public String saleDetailAsString() {
        StringBuilder sb = new StringBuilder(saleDetail.asText());
        sb.append("\n");
        sb.append("---------------------\n");
        sb.append("running total : " + runningTotal + "\n");
        return sb.toString();
    }

}

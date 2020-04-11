package model.salemodel;

import model.Calendar;
import model.discountmodel.DiscountEngine;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;

public class SaleDetail {
    private ProcessedGoods processedGoods;
    private ItemModel saleLineItem;
    private boolean active;
    private boolean completed;
    private double runningTotal = 0;
    private double totalCost = 0;
    private double totalVAT = 0;
    private double cashBack = 0;
    private String TimeAndDateOfSale;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */
    public SaleDetail(){
        completed = false;
        active = true;
        processedGoods = new ProcessedGoods();
    }

    public void setTimeAndDateOfSale(String timeAndDateOfSale) {
        TimeAndDateOfSale = timeAndDateOfSale;
    }

    public double getTotalVAT(){
        return totalVAT;
    }

    public String getTimeAndDateOfSale() {
        return TimeAndDateOfSale;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setSaleLineItem(ItemModel saleLineItem) {
        this.saleLineItem = saleLineItem;
    }

    public ProcessedGoods getProcessedGoods() {
        return processedGoods;
    }

    public String updateSaleDetail(){
        if (processedGoods.contains(saleLineItem.itemId))
           updateItemQuantity();
        else
            addItem();
        updateRunningTotal(saleLineItem.totalPrice);
        updateVAT();
        return saleDetailAsString();
    }

    private void updateVAT(){
        totalVAT += saleLineItem.taxRate * saleLineItem.quantity * saleLineItem.price;
    }

    private String updateItemQuantity(){
        processedGoods.getItem(saleLineItem.itemId).quantity += saleLineItem.quantity;
        return saleDetailAsString();
    }

    private void addItem() {
        processedGoods.getGoods().add(saleLineItem);
    }

    public double updateRunningTotal(double amount) {
        this.runningTotal += amount;
        if(runningTotal < 0) {
            cashBack = runningTotal;
            runningTotal = 0;
        }
        return runningTotal;
    }

    private String saleDetailAsString(){
        StringBuilder sb = new StringBuilder(processedGoods.processedGoodsAsText());
        sb.append("\n");
        sb.append("---------------------\n");
        sb.append("running total : " + runningTotal + "\n");
        return sb.toString();
    }

}

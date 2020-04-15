package model.salemodel;

import model.Calendar;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import java.util.Objects;

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
    private SaleId id;


    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */

    public SaleDetail() {
        id = new SaleId();
        completed = false;
        active = true;
        processedGoods = new ProcessedGoods();
    }


    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public void setId(SaleId id) {
        this.id = id;
    }

    public void setProcessedGoods(ProcessedGoods processedGoods) {
        this.processedGoods = processedGoods;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setSaleLineItem(ItemModel saleLineItem) {
        this.saleLineItem = saleLineItem;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    public ItemModel getSaleLineItem() {
        return saleLineItem;
    }


    public SaleId getSaleId(){
        return id;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public String getTimeAndDateOfSale() {
        return TimeAndDateOfSale;
    }

    public void setActive(boolean active) {
        this.active = active;
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


    public ProcessedGoods getProcessedGoods() {
        if (Objects.isNull(processedGoods))
            processedGoods = new ProcessedGoods();
        return processedGoods;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String addItemToSale(ItemModel item){
        saleLineItem = item;
        return updateSaleDetail();
    }

    public double updateRunningTotal(double amount) {
        this.runningTotal += amount;
        if (runningTotal < 0) {
            cashBack = -1 * runningTotal;
            runningTotal = 0;
        }
        return runningTotal;
    }

    public Double completeSale() {
        setCompleted(true);
        setTimeAndDateOfSale(Calendar.getTimeAndDate());
        return totalCost = runningTotal;
    }

    private String updateSaleDetail() {
        if (processedGoods.contains(saleLineItem.itemId))
            updateItemQuantity();
        else
            addItem();
        updateRunningTotal(saleLineItem.totalPrice);
        updateVAT();
        return saleDetailAsString();
    }

    private void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private void updateVAT() {
        totalVAT += saleLineItem.taxRate * saleLineItem.quantity * saleLineItem.price;
    }

    private String updateItemQuantity() {
        processedGoods.getItem(saleLineItem.itemId).quantity += saleLineItem.quantity;
        return saleDetailAsString();
    }

    private void addItem() {
        processedGoods.getGoods().add(saleLineItem);
    }

    private String saleDetailAsString() {
        StringBuilder sb = new StringBuilder(processedGoods.processedGoodsAsText());
        sb.append("\n");
        sb.append("---------------------\n");
        sb.append("running total : " + runningTotal + "\n");
        return sb.toString();
    }

    private void setTimeAndDateOfSale(String timeAndDateOfSale) {
        TimeAndDateOfSale = timeAndDateOfSale;
    }
}

package model.salemodel;

import model.discountmodel.Discount;

import util.Calendar;
import model.itemmodel.ItemModel;
import java.util.HashMap;
import java.util.Map;


public class SaleDetail {
    private HashMap<Integer,ItemModel> goods;
    private Discount discount;
    private boolean active;
    private boolean completed;
    private String timeAndDateOfSale;
    private SaleId id;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */
    public SaleDetail() {

    }

    public void createDefault() {
        setSaleId(new SaleId());
        setCompleted(false);
        setActive(true);
        setTimeAndDateOfSale(Calendar.getTimeAndDate());
        goods = new HashMap<>();
    }

    public HashMap<Integer,ItemModel> getGoods(){
        return goods;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setGoods(HashMap<Integer, ItemModel> goods) {
        this.goods = goods;
    }

    public SaleId getSaleId(){
        return id;
    }

    public void setSaleId(SaleId id) {
        this.id = id;
    }

    public SaleId getId() {
        return id;
    }

    public void setId(SaleId id) {
        this.id = id;
    }

    public String getTimeAndDateOfSale() {
        return this.timeAndDateOfSale;
    }

    private void setTimeAndDateOfSale(String timeAndDateOfSale) {
        this.timeAndDateOfSale = timeAndDateOfSale;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String asText() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, ItemModel> entry : goods.entrySet()) {
            sb.append(entry.getValue().getName());
            sb.append(" x ");
            sb.append(entry.getValue().getQuantity());
            sb.append(" ");
            sb.append(entry.getValue().getTotalPrice());
            sb.append(" kr ");
            sb.append("( " + entry.getValue().getPrice() + "kr/pce excluding tax of " + entry.getValue().getTaxRate()*entry.getValue().getPrice());
            sb.append("\n");
        }
        sb.append("Time and date of sale : " + timeAndDateOfSale + "\n");
        return sb.toString();
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
/*
    public void setProcessedGoods(ProcessedGoods processedGoods) {
        this.processedGoods = processedGoods;
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


    public void setSaleLineItem(ItemModel saleLineItem) {
        this.saleLineItem = saleLineItem;
    }

    public ProcessedGoods getProcessedGoods() {
        if (Objects.isNull(processedGoods))
            processedGoods = new ProcessedGoods();
        return processedGoods;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void completeSale() {
        setCompleted(true);
        setTimeAndDateOfSale(Calendar.getTimeAndDate());
        totalCost = runningTotal;
    }

    public String updateSaleDetail() {

        if (processedGoods.contains(saleLineItem.getItemId()))
            updateItemQuantity();
        else
            addItem();
        updateRunningTotal(saleLineItem.getTotalPrice());
        updateVAT();
        return saleDetailAsString();
    }


    private void updateVAT() {
        totalVAT += saleLineItem.getTaxRate() * saleLineItem.getQuantity() * saleLineItem.getPrice();
    }


    public double updateRunningTotal(double amount) {
        this.runningTotal += amount;
        if (runningTotal < 0) {
            cashBack = -1 * runningTotal;
            runningTotal = 0;
        }
        return runningTotal;
    }

    private String updateItemQuantity() {
        processedGoods.getItem(saleLineItem.getItemId()).setQuantity(saleLineItem.getQuantity() + processedGoods.getItem(saleLineItem.getItemId()).getQuantity());
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

 */
}

package model.salemodel;

import model.discountmodel.Discount;
import util.Calendar;

import java.util.HashMap;
import java.util.Map;


public class SaleDetail {
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
    }



    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
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

        return "sb.toString()";
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

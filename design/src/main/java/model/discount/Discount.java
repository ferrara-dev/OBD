package model.discount;

import model.discount.discounttypes.pricediscount.PriceDiscount;


/**
 * A model representing a discount that is applied to
 * a specific sale
 */

public abstract class Discount{
    private double totalPriceReduction = 0;
    private String date;

    public Discount() {

    }

    public void setPriceDiscount(PriceDiscount priceDiscount){

    }

    public Double getTotalPriceReduction() {
        return totalPriceReduction;
    }

    public void setTotalPriceReduction(Double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

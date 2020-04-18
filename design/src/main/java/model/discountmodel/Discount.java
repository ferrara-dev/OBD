package model.discountmodel;

import integration.customerdb.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A model representing a discount that is applied to
 * a specific sale
 */

public class Discount<ItemDiscount, PriceDiscount> {
    private List<ItemDiscount> itemDiscounts;
    private List<PriceDiscount> priceDiscounts;
    private Customer customer;
    private double totalPriceReduction = 0;
    private String date;

    public Discount() {
        itemDiscounts = new ArrayList<>();
        priceDiscounts = new ArrayList<>();
    }

    public List<ItemDiscount> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(ItemDiscount... discounts) {
        itemDiscounts.addAll(Arrays.asList(discounts));
    }

    public List<PriceDiscount> getPriceDiscounts() {
        return priceDiscounts;
    }

    public void setPriceDiscounts(PriceDiscount... discounts) {
        priceDiscounts.addAll(Arrays.asList(discounts));
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

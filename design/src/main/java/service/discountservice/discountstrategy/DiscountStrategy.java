package service.discountservice.discountstrategy;
import integration.datatransferobject.DiscountDTO;


import java.util.ArrayList;

public interface DiscountStrategy {
    String BULK_DISCOUNT = "Bulk Discount";
    String PRICE_DISCOUNT = "Price Discount";


    boolean applyStrategy(DiscountDTO discountDTOs);
    ArrayList getDiscountPolicies();
    void calculateDiscount();
    void applyDiscount();
}

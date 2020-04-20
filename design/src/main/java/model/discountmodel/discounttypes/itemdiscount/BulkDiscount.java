package model.discountmodel.discounttypes.itemdiscount;

import model.itemmodel.Product;
import service.discountservice.discountpolicy.BulkDiscountPolicy;

import java.util.List;


public class BulkDiscount extends ItemDiscount {
    private double totalPriceReduction;

    public BulkDiscount(BulkDiscountPolicy policy){
        super(policy);

    }
    public void setTotalPriceReduction(double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
    }

    public double getTotalPriceReduction() {
        return 0;
    }

    public String getDiscountType() {
        return null;
    }
}

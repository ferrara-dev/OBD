package model.discount.discounttypes.itemdiscount;

import model.discount.discountpolicy.BulkDiscountPolicy;


public class BulkDiscount extends ItemDiscount {

    private double totalPriceReduction;
    public BulkDiscount(BulkDiscountPolicy policy){
        super(policy);
    }

    public void setTotalPriceReduction(double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
    }

    public Double getTotalPriceReduction() {
        return 0D;
    }

    public String getDiscountType() {
        return null;
    }
}

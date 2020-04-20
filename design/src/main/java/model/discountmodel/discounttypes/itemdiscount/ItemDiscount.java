package model.discountmodel.discounttypes.itemdiscount;

import model.itemmodel.Product;
import service.discountservice.discountpolicy.DiscountPolicy;

public abstract class ItemDiscount {
    protected Product discountedProduct;
    protected final double totalPriceReduction;

    public ItemDiscount(DiscountPolicy policy){
        totalPriceReduction = policy.getTotalPriceReduction();
    }

    public Product getDiscountedItems(){
        return this.discountedProduct;
    }

    public double getTotalPriceReduction(){
        return this.getTotalPriceReduction();
    }
}

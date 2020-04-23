package model.discount.discounttypes.itemdiscount;
import model.discount.Discount;
import model.discount.discountpolicy.DiscountPolicy;

public abstract class ItemDiscount extends Discount {
    protected DiscountPolicy discountPolicy;
    protected final double totalPriceReduction;

    public ItemDiscount(DiscountPolicy policy){
        this.discountPolicy = policy;
        totalPriceReduction = policy.getTotalPriceReduction();
    }

    @Override
    public Double getTotalPriceReduction() {
        return totalPriceReduction;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}

package model.discount.discounttypes.pricediscount;

import model.discount.Discount;
import model.discount.discountpolicy.PriceDiscountPolicy;

public class PriceDiscount extends Discount {
    private PriceDiscountPolicy priceDiscountPolicy;
    private double discountRate;
    private double totalPriceReduction;

    public PriceDiscount(PriceDiscountPolicy policy) {
        this.priceDiscountPolicy = policy;
        discountRate = policy.getReduction();
        totalPriceReduction = policy.getTotalPriceReduction();
    }

    @Override
    public Double getTotalPriceReduction() {
        return totalPriceReduction;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

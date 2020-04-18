package model.discountmodel.discounttypes.pricediscount;
import service.discountservice.discountpolicy.PriceDiscountPolicy;

public class PriceDiscount {
    private double discountRate;
    private double totalPriceReduction;

    public PriceDiscount(PriceDiscountPolicy policy){
            discountRate = policy.getReduction();
            totalPriceReduction = policy.getTotalPriceReduction();
    }

    public double getTotalPriceReduction() {
        return totalPriceReduction;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

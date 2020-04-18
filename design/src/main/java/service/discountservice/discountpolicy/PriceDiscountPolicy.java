package service.discountservice.discountpolicy;

import model.discountmodel.discounttypes.pricediscount.PriceDiscount;
import model.salemodel.Sale;

public class PriceDiscountPolicy extends DiscountPolicy {
    private final String discountClass = "Price discount";
    private final double minimumSpent;
    private final double reduction;
    private double totalPriceReduction;

    public PriceDiscountPolicy(double minimumSpent, double reduction){
        this.minimumSpent = minimumSpent;
        this.reduction = reduction;
    }

    public double getMinimumSpent() {
        return minimumSpent;
    }

    public double getReduction() {
        return reduction;
    }

    public String getDiscountClass() {
        return discountClass;
    }

    @Override
    public PriceDiscount calculateDiscount(Sale sale) {
        if(sale.getSaleDetail().isCompleted() && sale.getSaleDetail().isActive()) {
            double totalPrice = sale.getTotalCost();
            if (minimumSpent <= totalPrice)
                totalPriceReduction = totalPrice*reduction;
        }

        else if(sale.getSaleDetail().isActive() && !sale.getSaleDetail().isCompleted()){
            double totalPrice = sale.getTotalCost();
            if (minimumSpent <= totalPrice)
                totalPriceReduction = totalPrice*reduction;
        }

        return new PriceDiscount(this);
    }

    @Override
    public double getTotalPriceReduction() {
        return totalPriceReduction;
    }
}

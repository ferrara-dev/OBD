package model.discount.discountpolicy;

import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.sale.Sale;

public class PriceDiscountPolicy extends DiscountPolicy {
    private final String discountClass = "Price discount";
    private final double minimumSpent;
    private final double reduction;
    private double totalPriceReduction;

    public PriceDiscountPolicy(double minimumSpent, double reduction){
        this.minimumSpent = minimumSpent;
        this.reduction = reduction;
    }

    public void setTotalPriceReduction(double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
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
    public void calculateDiscount(Sale sale) {
        if(sale.getSaleDetail().isCompleted() && sale.getSaleDetail().isActive()) {
            double totalPrice = sale.getCost().getTotalCost();
            if (minimumSpent <= totalPrice) {
                totalPriceReduction = totalPrice * reduction;
                sale.getCost().setPriceDiscount(new PriceDiscount(this));
            }
        }

        else if(sale.getSaleDetail().isActive() && !sale.getSaleDetail().isCompleted()){
            double totalPrice = sale.getCost().getTotalCost();
            if (minimumSpent <= totalPrice)
                totalPriceReduction = totalPrice*reduction;
                sale.getCost().setPriceDiscount(new PriceDiscount(this));
        }

    }

    @Override
    public double getTotalPriceReduction() {
        return totalPriceReduction;
    }
}

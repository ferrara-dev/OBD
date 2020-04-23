package model.discount.discountpolicy;

import model.sale.Sale;

public abstract class DiscountPolicy <Obj> {
    public abstract void calculateDiscount(Sale sale);
    public abstract String getDiscountClass();
    public abstract double getTotalPriceReduction();
}

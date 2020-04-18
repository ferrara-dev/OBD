package service.discountservice.discountpolicy;

import model.salemodel.Sale;

public abstract class DiscountPolicy <Obj> {
    public abstract Obj calculateDiscount(Sale sale);
    public abstract String getDiscountClass();
    public abstract double getTotalPriceReduction();
}

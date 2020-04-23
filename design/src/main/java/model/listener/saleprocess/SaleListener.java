package model.listener.saleprocess;

import model.discount.Discount;
import model.listener.ModelListener;
import model.sale.Cost;


public interface SaleListener extends ModelListener {
    void runningTotalHasChanged(double runningTotal);
    void discountWasApplied(Discount appliedDiscount);
    void costHasChanged(Cost IncreasedCost);
}


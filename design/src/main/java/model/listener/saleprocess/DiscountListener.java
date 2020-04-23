package model.listener.saleprocess;
import model.discount.discounttypes.itemdiscount.ItemDiscount;
import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.listener.ModelListener;

import java.util.List;

public interface DiscountListener extends ModelListener {

    void itemDiscountWasApplied(List<ItemDiscount> appliedItemDiscount);
    void priceDiscountWasApplied(List<PriceDiscount> appliedPriceDiscount);
    void discountWasApplied(double totalPriceReduction);
}

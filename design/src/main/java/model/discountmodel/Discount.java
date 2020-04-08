package model.discountmodel;

import integration.DiscountRegestry;
import integration.ItemRegestry;
import integration.RegestryCreator;
import model.salemodel.SaleModel;

public interface Discount {
    DiscountRegestry DISCOUNT_REGESTRY = RegestryCreator.getDiscountRegestry();
    ItemRegestry ITEM_REGESTRY = RegestryCreator.getItemRegestry();


    int getItemId();
    int getRequirement();
    void increasePriceReduction(double amount);
    double getPriceReduction();
}

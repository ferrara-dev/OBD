package model.discountmodel;

import integration.DiscountRegestry;
import integration.ItemRegestry;
import integration.RegestryCreator;
import model.salemodel.SaleModel;

public interface Discount {



    int getItemId();
    int getRequirement();
    void increasePriceReduction(double amount);
    double getPriceReduction();
}

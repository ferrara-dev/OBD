package model.discountmodel.discounttypes.itemdiscount;

import model.itemmodel.ItemModel;
import service.discountservice.discountpolicy.BuyNItemsGetMFreePolicy;

import java.util.List;

public class BuyNItemsGetMFree extends ItemDiscount {
    private List<ItemModel> discountedItems;
    double totalPriceReduction;

    public BuyNItemsGetMFree(BuyNItemsGetMFreePolicy policy) {

    }

    @Override
    List getDiscountedItems() {
        return discountedItems;
    }

    public double getTotalPriceReduction() {
        return 0;
    }

    public String getDiscountType() {
        return null;
    }
}

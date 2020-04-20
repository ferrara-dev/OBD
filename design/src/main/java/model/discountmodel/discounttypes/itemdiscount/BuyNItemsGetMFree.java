package model.discountmodel.discounttypes.itemdiscount;

import model.itemmodel.Product;
import service.discountservice.discountpolicy.BuyNItemsGetMFreePolicy;

public class BuyNItemsGetMFree extends ItemDiscount {
    private Product discountedItem;
    private int requiredAmountOfItems;

    public BuyNItemsGetMFree(BuyNItemsGetMFreePolicy policy) {
        super(policy);
    }

    public String getDiscountType() {
        return null;
    }

    @Override
    public double getTotalPriceReduction(){
        return super.totalPriceReduction;
    }
}

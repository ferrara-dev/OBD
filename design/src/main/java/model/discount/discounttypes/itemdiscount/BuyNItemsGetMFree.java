package model.discount.discounttypes.itemdiscount;

import model.item.Product;
import model.discount.discountpolicy.BuyNItemsGetMFreePolicy;

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
    public Double getTotalPriceReduction(){
        return super.totalPriceReduction;
    }
}

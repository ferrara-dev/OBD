package model.discountmodel.discounttypes.itemdiscount;

import model.discountmodel.discounttypes.itemdiscount.ItemDiscount;
import model.itemmodel.ItemModel;
import service.discountservice.discountpolicy.BulkDiscountPolicy;

import java.util.List;


public class BulkDiscount extends ItemDiscount {
    private List<ItemModel> discountedItems;
    private double totalPriceReduction;

    public BulkDiscount(BulkDiscountPolicy policy){
        discountedItems = policy.getDiscountedItems();
        totalPriceReduction = policy.getTotalPriceReduction();
    }

    public void setTotalPriceReduction(double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
    }

    public void setDiscountedItems(List<ItemModel> discountedItems) {
        this.discountedItems = discountedItems;
    }

    public List<ItemModel> getDiscountedItems() {
        return discountedItems;
    }

    public double getTotalPriceReduction() {
        return 0;
    }

    public String getDiscountType() {
        return null;
    }
}

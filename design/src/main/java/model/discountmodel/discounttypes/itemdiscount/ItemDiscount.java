package model.discountmodel.discounttypes.itemdiscount;

import model.itemmodel.ItemModel;

import java.util.List;

public abstract class ItemDiscount {

    abstract List<ItemModel> getDiscountedItems();

}

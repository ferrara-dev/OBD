package integration.productdb;

import integration.ItemDetail;

public class Item {
    ItemDetail itemDetail;
    boolean hasDiscount = false;

    public Item(String name, double price, String category, int itemId, int stockStatus){
        itemDetail = new ItemDetail(name,price,category,itemId,stockStatus);
    }

    public ItemDetail getItemDetail() {
        return itemDetail;
    }
}

package model.itemmodel;

import model.itemmodel.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ProcessedGoods {
    private List<ItemModel> goods;

    public List<ItemModel> getGoods(){
        return goods;
    }

    public ProcessedGoods() {
        goods = new ArrayList<>();
    }

    public boolean contains(int itemId){
        for (ItemModel item : goods)
            if (itemId == item.itemId)
                return true;

        return false;
    }

    public  ItemModel getItem(int itemId) {
        for(ItemModel item: goods)
            if(itemId == item.itemId){
                return item;
            }
        return null;
    }

    public int getItemQuantity(int itemId){
        for(ItemModel item: goods)
            if(itemId == item.itemId){
                return item.quantity;
            }
        return 0;
    }

    public String processedGoodsAsText(){
        String goodsAsString = new String();
        System.out.println(goods.size());
        for(ItemModel item: goods){
            goodsAsString =  goodsAsString + " " +
                    "" + item.name + " x " + item.quantity + "  " + item.totalPrice + " " +
                    "kr ( " + item.price + "kr/pce excluding tax of " + item.taxRate*item.price + "kr " + " )" +
                    "" + "\n";
        }
        return goodsAsString;
    }

/**
    public void addItemToSale(SaleDetail saleDetail){
        if (contains(saleDetail.getItemModel().itemId))
            updateItemQuantity(saleDetail);
         else
            goods.add(saleDetail.getItemModel());
    }

    public void updateItemQuantity(ItemModel model){
        getItem(model.itemId).quantity += model.quantity;
    }

    public void addItem(ItemModel itemModel) {
        goods.add(itemModel);
     }
**/

}

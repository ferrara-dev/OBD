package model.salemodel;


import integration.RegestryCreator;
import model.itemmodel.ItemModel;
import model.Model;

import java.util.Objects;

public class SaleModel implements Model {
    public SaleDetail saleDetail;
    public RegestryCreator creator;
    private final int ITEM_NOT_FOUND = 0;

    public SaleModel(RegestryCreator creator) {
        this.creator = creator;
    }

    @Override
    public String registerItem(int itemId, int quantity) {
        boolean isRegistered = false;
        if(Objects.isNull(saleDetail)) {
            startSale();
        }
        if(!saleDetail.completed) {
            if (creator.getItemRegestry().contains(itemId)) {
                ItemModel itemModel = new ItemModel(creator.getItemRegestry().getItemDetail(itemId), quantity);
                if (saleDetail.active && itemModel != null) {
                    saleDetail.setSaleLineItem(itemModel);
                    addItemToSale();
                    return getDisplayMessage(itemId, true);
                }
            }
        }
        return getDisplayMessage(ITEM_NOT_FOUND, false);
    }

    public void startSale() {
        saleDetail = new SaleDetail();
    }

    public String endSale() {
        saleDetail.completed = true;
        return Double.toString(saleDetail.getRunningTotal());
    }

    private String getDisplayMessage(int itemId, boolean itemFound) {
        if(itemFound) {
            String message = saleDetail.getSaleLineItem().toString() + "\n" +
                    "Running Total : " + saleDetail.getRunningTotal() + "\n" +
                    "Total Amount of this Item : " + saleDetail.getProcessedGoods().getItem(itemId).quantity;

            return message;
        }
        return "Item not found";
    }

    private void addItemToSale(){
        saleDetail.updateSaleDetail();
    }


}

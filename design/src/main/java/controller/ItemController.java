package controller;

import integration.ItemDetail;
import model.itemmodel.ItemModel;
import model.itemmodel.ItemScanner;
import startup.LayerCreator;

public class ItemController {
    SaleController saleController;
    ItemScanner itemScanner;
    service.productservice.ItemScanner itemScanner1;
    public ItemController(LayerCreator creator){
        saleController = creator.getSaleController();
        itemScanner = new ItemScanner(creator.getRegestryCreator().getItemRegestry());
        itemScanner1 = new service.productservice.ItemScanner(creator.getRegestryCreator().getItemRegestry());
    }

    /**
     * First call itemScanner to fetch information about item
     * mapped to the given item id.
     * call model to register an item to the sale
     * @param itemId
     * @param quantity
     * @return
     */
    public String registerItem(int itemId, int quantity) {
        ItemDetail itemDetail = itemScanner1.scanId(itemId);
        String displayMessage = saleController.registerItem(itemDetail, quantity);
        return displayMessage;
    }

    public ItemModel registerItem2(int itemId, int quantity) {
        ItemModel itemModel =
        return null;
    }
}

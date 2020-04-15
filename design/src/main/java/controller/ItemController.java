package controller;

import integration.ItemDetail;
import model.itemmodel.ItemScanner;
import startup.LayerCreator;

public class ItemController {
    SaleController saleController;
    ItemScanner itemScanner;

    public ItemController(LayerCreator creator){
        saleController = creator.getSaleController();
        itemScanner = new ItemScanner(creator.getRegestryCreator().getItemRegestry());
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
        ItemDetail itemDetail = itemScanner.scanId(itemId);
        String displayMessage = saleController.registerItem(itemDetail, quantity);
        return displayMessage;
    }
}

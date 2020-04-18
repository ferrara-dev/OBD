package controller;

import integration.productdb.ItemDTO;
import service.inventoryservice.ItemScanner;
import startup.LayerCreator;

public class ItemController {
    SaleController saleController;
    ItemScanner itemScanner;

    public ItemController(LayerCreator creator){
        saleController = creator.getSaleController();
        itemScanner = new ItemScanner();
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
        ItemDTO itemDTO = itemScanner.scanId(itemId);
        String displayMessage = saleController.registerItem(itemDTO, quantity);
        return displayMessage;
    }
}

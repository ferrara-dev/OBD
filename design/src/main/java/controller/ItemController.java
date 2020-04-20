package controller;

import model.itemmodel.Product;
import service.inventoryservice.ItemService;
import startup.LayerCreator;

public class ItemController {
    private final SaleController saleController;
    private final ItemService itemService;

    public ItemController(LayerCreator creator){
        saleController = creator.getSaleController();
        itemService = new ItemService();
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
        Product product =  itemService.getItem(itemId);
        String displayMessage = saleController.registerItem(product, quantity);
        return displayMessage;
    }
}

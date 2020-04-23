package controller;

import model.item.Product;
import service.inventoryservice.ItemService;
import startup.ServiceFactory;

public class ItemController extends AbstractController{
    private final ItemService itemService;

    public ItemController(ServiceFactory serviceFactory){
        super(serviceFactory);
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
    public void registerItem(int itemId, int quantity) {
        Product product =  itemService.getItem(itemId);
        super.saleService.registerItem(product, quantity);
    }
}

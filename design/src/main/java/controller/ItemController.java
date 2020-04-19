package controller;

<<<<<<< HEAD
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
=======
import integration.productdb.ItemDTO;
import service.inventoryservice.ItemScanner;
import service.inventoryservice.ItemService;
import startup.LayerCreator;

public class ItemController {
    private final SaleController saleController;
    private final ItemService itemService;

    public ItemController(LayerCreator creator){
        saleController = creator.getSaleController();
        itemService = new ItemService();
>>>>>>> origin/master
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
<<<<<<< HEAD
        ItemDetail itemDetail = itemScanner1.scanId(itemId);
        String displayMessage = saleController.registerItem(itemDetail, quantity);
=======
        ItemDTO itemDTO =  itemService.getItem(itemId);
        String displayMessage = saleController.registerItem(itemDTO, quantity);
>>>>>>> origin/master
        return displayMessage;
    }

    public ItemModel registerItem2(int itemId, int quantity) {
        ItemModel itemModel =
        return null;
    }
}

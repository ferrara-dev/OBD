package service.inventoryservice;

import integration.DBService;
import integration.DataBaseHandler;
import integration.productdb.InventoryHandler;
import integration.productdb.ItemDTO;

/**
 * Scans <code> itemId <\code> and fetches instance of <code> ItemDTO <\code>
 * from the InventoryHandler
 */
public class ItemScanner {
    private final DataBaseHandler <ItemDTO,Integer> inventoryHandler = new InventoryHandler();
    public ItemScanner(){

    }

    /**
     * Scan the itemId and fetch details
     * @param itemId
     * @return details about the item that is mapped to the id given in the
     */
    public ItemDTO scanId(int itemId){
        return fetchItemDetail(itemId);
    }

    /**
     * fetch information about an item from the item registry
     * throws ItemNotFoundException if the item is not found.
     *
     * @param itemId
     * @return Detailed information about the item with the
     * given itemIdentifier
     */
    private ItemDTO fetchItemDetail(int itemId) {
        return inventoryHandler.collect(String.valueOf(itemId));
    }
}

package service.inventoryservice;

import integration.DBService;
import integration.productdb.ItemDTO;

/**
 * Class representing a scanner used by the cashier to read the itemId
 */
public class ItemScanner {

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
        return DBService.getProduct(String.valueOf(itemId));
    }
}

package service.inventoryservice;

import integration.DataBaseHandler;
import integration.productdb.InventoryHandler;
import integration.datatransferobject.ItemDTO;
import model.itemmodel.Product;

/**
 * Class representing a scanner used by the cashier to read the itemId
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
    public Product scanId(int itemId){
        ItemDTO dto = fetchItemDetail(itemId);
        Product product = new Product();
        product.setAttributes(dto);
        return product;
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

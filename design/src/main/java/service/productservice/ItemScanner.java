package service.productservice;


import integration.ItemDetail;
import integration.ItemRegestry;
import util.NotFoundException;

/**
 * Class representing a scanner used by the cashier to read the item id
 */

public class ItemScanner {
    ItemRegestry registry;

    public ItemScanner(ItemRegestry registry){
        this.registry = registry;
    }

    /**
     * Scan the itemId and fetch details about the item that is mapped
     * to the specified id
     * @param itemId
     * @return details about the item that is mapped to the id specified
     */

    public ItemDetail scanId(int itemId){
        return fetchItemDetail(itemId);
    }

    /**
     * fetch information about an item from the item registry
     * throws NotFoundException if the item is not found.
     *
     * @param itemId
     * @return Detailed information about the item with the
     * given itemIdentifier
     */
    private ItemDetail fetchItemDetail(int itemId) {
        if (!registry.contains(itemId))
            throw new NotFoundException("Item not found");
        return registry.getItemDetail(itemId);
    }
}

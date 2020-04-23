package service.inventoryservice;

import integration.datatransferobject.ItemDTO;
import model.item.Product;


public class ItemService {
    private final ItemScanner itemScanner = new ItemScanner();

    public ItemService(){

    }

    public Product getItem(int itemId){
        return itemScanner.scanId(itemId);
    }

    public Product createItemModel(ItemDTO itemDTO){
        Product product = new Product();
        product.setAttributes(itemDTO);
        return product;
    }

}

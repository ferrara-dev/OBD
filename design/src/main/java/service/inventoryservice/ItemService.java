package service.inventoryservice;

import integration.datatransferobject.ItemDTO;
import model.itemmodel.Product;


public class ItemService {
    private final ItemScanner itemScanner = new ItemScanner();

    public ItemService(){

    }

    public Product getItem(int itemId){
        return itemScanner.scanId(itemId);
    }

    public Product createItemModel(ItemDTO itemDTO, int quantity){
        Product product = new Product();
        product.setAttributes(itemDTO);
        //product.setQuantity(quantity);
    //    product.setTotalPrice();
   //     product.setTotalVAT(product.getQuantity() * product.getPrice() * product.getTaxRate());
        return product;
    }


    public void updateItemQuantity(){

    }
}

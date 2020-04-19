package service.inventoryservice;

import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;


public class ItemService {
    private final ItemScanner itemScanner = new ItemScanner();

    public ItemService(){

    }

    public ItemDTO getItem(int itemId){
        return itemScanner.scanId(itemId);
    }

    public ItemModel createItemModel(ItemDTO itemDTO, int quantity){
        ItemModel itemModel = new ItemModel();
        itemModel.createItemModel(itemDTO);
        itemModel.setQuantity(quantity);
        itemModel.setTotalPrice();
        itemModel.setTotalVAT(itemModel.getQuantity() * itemModel.getPrice() * itemModel.getTaxRate());
        return itemModel;
    }


    public void updateItemQuantity(){

    }
}

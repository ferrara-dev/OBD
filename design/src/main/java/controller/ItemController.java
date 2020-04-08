package controller;

import startup.LayerCreator;

public class ItemController {
    LayerCreator creator;
    public ItemController(LayerCreator creator){
       this.creator = creator;
    }


    public String registerItem(int itemId, int quantity) {
        String displayMessage = creator.getSaleController().salemodel.registerItem(itemId,quantity);
        return displayMessage;
    }
}

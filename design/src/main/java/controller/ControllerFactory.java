package controller;

import startup.LayerCreator;

public final class ControllerFactory {
    SaleController saleController;
    ItemController itemController;
    DiscountController discountController;


    public ControllerFactory(LayerCreator layerCreator){
        saleController = new SaleController(layerCreator.getServiceFactory());
        itemController = new ItemController(layerCreator.getServiceFactory());
        discountController = new DiscountController(layerCreator.getServiceFactory());
    }

    public DiscountController getDiscountController() {
        return discountController;
    }

    public ItemController getItemController() {
        return itemController;
    }

    public SaleController getSaleController() {
        return saleController;
    }
}

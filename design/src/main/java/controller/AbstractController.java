package controller;


import model.listener.ModelListener;
import service.discountservice.DiscountService;
import service.inventoryservice.ItemService;
import service.saleservice.PaymentService;
import service.saleservice.SaleService;
import startup.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController {
    protected List<ModelListener> modelListeners;
    protected SaleService saleService;
    protected ItemService itemService;
    protected DiscountService discountService;
    protected PaymentService paymentService;

    public AbstractController(ServiceFactory serviceFactory){
        modelListeners = new ArrayList<>();
        saleService = serviceFactory.getSaleService();
        itemService = serviceFactory.getItemService();
        discountService = serviceFactory.getDiscountService();
    }

    protected void registerListeners(ModelListener modelListener){
        modelListeners.add(modelListener);
    }

}

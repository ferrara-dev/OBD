package controller;

import integration.ItemRegestry;
import integration.RegestryCreator;
import model.salemodel.SaleModel;


public class SaleController {
    private static SaleModel salemodel;
    public DiscountController discountController;
    private ItemRegestry itemRegestry;
    private RegestryCreator creator;

    public SaleController(RegestryCreator creator){
        this.creator = creator;
        itemRegestry = creator.getItemRegestry();
        salemodel = new SaleModel(creator);
        discountController = new DiscountController(this);
    }

    public String startSale(){
        salemodel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    public String registerItem(int itemId, int quantity) {
        //call to model
        String displayMessage = salemodel.registerItem(itemId,quantity);
        return displayMessage;
    }

    public String endSale(){
        // call to Salemodel
        return salemodel.endSale();
    }

    public SaleModel getSalemodel() {
        return salemodel;
    }
}

package controller;

import model.discountmodel.DiscountEngine;
import startup.LayerCreator;


public class DiscountController {
    private LayerCreator creator;

    DiscountEngine discountEngine;
    public DiscountController(LayerCreator LayerCreator){
        this.creator = LayerCreator;
    }

    public String signalDiscountRequest(String customerId){
        if(integration.customerdb.CustomerDB.find(customerId)){
            discountEngine = new DiscountEngine(creator.getSaleController().salemodel.saleDetail);
            return "total discount of : " + discountEngine.totalPriceReduction;
        }
        return "Customer Id not found";
    }

}

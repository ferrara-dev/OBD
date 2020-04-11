package controller;

import model.discountmodel.DiscountEngine;
import startup.LayerCreator;
import util.NotFoundException;


public class DiscountController {
    private LayerCreator creator;
    DiscountEngine discountEngine;

    public DiscountController(LayerCreator LayerCreator){
        this.creator = LayerCreator;
    }

    public String signalDiscountRequest(String customerId){
        if(integration.customerdb.CustomerDB.find(customerId)){
            discountEngine = new DiscountEngine(creator.getSaleController().salemodel.saleDetail);
          //  creator.getSaleController().
            return "total discount of : " + discountEngine.totalPriceReduction;
        }
        else
            throw new NotFoundException("Item not found");

    }

}

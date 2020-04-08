package controller;

import model.discountmodel.DiscountEngine;
import model.salemodel.SaleModel;

public class DiscountController {
    private SaleController saleController;
    DiscountEngine discountEngine;
    public DiscountController(SaleController saleController){
        this.saleController = saleController;
    }

    public String signalDiscountRequest(String customerId){
        if(integration.customerdb.CustomerDB.find(customerId)){
            discountEngine = new DiscountEngine(saleController.getSalemodel().saleDetail);
            return "total discount of : " + discountEngine.totalPriceReduction;
        }
        return "Customer Id not found";
    }

}

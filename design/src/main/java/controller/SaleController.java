package controller;

import integration.RegestryCreator;
import model.salemodel.Register;
import model.salemodel.SaleModel;


public class SaleController {
    public SaleModel salemodel;
    private RegestryCreator creator;
    Register cashRegister;

    public SaleController(RegestryCreator creator){
        this.creator = creator;
        cashRegister = new Register();
    }

    public String startSale(){
        if(salemodel == null)
            salemodel = new SaleModel(creator);

        salemodel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    public String endSale(){
        // call to Salemodel
        return salemodel.endSale();
    }


    public void enterPayment(double amount){
        if(cashRegister.processPayment(salemodel.saleDetail, amount) >= 0) {
            logSale();
            String change = Double.toString(cashRegister.processPayment(salemodel.saleDetail, amount));
        }
    }

    public void logSale(){
        creator.getSaleLog().logSale(salemodel.saleDetail);
    }
}

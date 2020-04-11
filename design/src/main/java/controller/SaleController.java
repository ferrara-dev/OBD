package controller;

import integration.Printer;
import model.salemodel.Payment;
import model.salemodel.Receipt;
import model.salemodel.SaleModel;
import startup.LayerCreator;

public class SaleController {
    public SaleModel salemodel;
    private LayerCreator creator;


    public SaleController(LayerCreator creator){
        this.creator = creator;
    }

    /**
     * call saleModel to initialize a new sale opportunity.
     * The sale model will be created if it
     * hasn't been initialized.
     * @return message shown by the gui to confirm the start of a new sale
     */
    public String startSale(){
        if(salemodel == null)
            salemodel = new SaleModel(creator.getRegestryCreator());

        salemodel.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    /**
     * call saleModel to end the sale after all items has been registered
     * @return message shown by the gui to present total cost
     */
    public String endSale(){
        // call to Salemodel
        return salemodel.endSale();
    }

    /**
     * call to the cash register to processes a payment
     * @param amountPayed
     * @return returns information that is forwarded to a printer that prints a receipt
     */
    public String enterPayment(double amountPayed){
        String receipt;
        Payment payment = new Payment(salemodel.saleDetail, amountPayed);
        creator.getPhysicalObjectCreator().getCashRegister().processPayment(payment);
        if(salemodel.saleDetail.getRunningTotal() >= 0) {
            salemodel.saleDetail.setActive(false);
            logSale();
            receipt = Printer.print((new Receipt(payment, creator.getPhysicalObjectCreator().getStore(), salemodel.saleDetail)));
        }
        else
            return "Still " + Double.toString(salemodel.saleDetail.getRunningTotal()) + " left to pay";
        return receipt;
    }

    /**
     * applies a calculated discount to current sale
     * @param priceReduction
     * @return
     */
    String applyDiscountToSale(double priceReduction){
       return null;
    }

    private void logSale(){
        creator.getRegestryCreator().getSaleLog().logSale(salemodel.saleDetail);
    }


}

package controller;

import integration.ItemDetail;
import integration.Printer;
import model.itemmodel.ItemModel;
import model.salemodel.Payment;
import model.salemodel.Receipt;
import model.salemodel.SaleModel;
import service.saleservice.SaleService;
import startup.LayerCreator;

import java.util.Objects;

public class SaleController {
    private SaleModel salemodel;
    private LayerCreator creator;
    SaleService saleService;

    public SaleController(LayerCreator creator){
        this.creator = creator;
        saleService = new SaleService(salemodel);
    }

    public String registerItem(ItemDetail itemDetail , int quantity){
        ItemModel itemModel = new ItemModel(itemDetail, quantity);
        return salemodel.registerItem(itemModel);
    }

    public SaleModel getSalemodel() {
        if(Objects.isNull((salemodel)))
            startSale();
        return salemodel;
    }

    /**
     * call saleModel to initialize a new sale opportunity.
     * The sale model will be created if it
     * hasn't been initialized or if the last sale has been completed
     * and logged.
     * @return message shown by the gui to confirm the start of a new sale
     */
    public String startSale(){
        if(salemodel == null || salemodel.getSaleDetail().isCompleted())
            salemodel = new SaleModel();

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
        String receiptString;
        Payment payment = new Payment(salemodel.getSaleDetail(), amountPayed);
        creator.getPhysicalObjectCreator().getCashRegister().processPayment(payment);
        if(salemodel.getSaleDetail().getRunningTotal() >= 0) {
            salemodel.getSaleDetail().setActive(false);
            logSale();
            Receipt receipt = new Receipt(payment, creator.getPhysicalObjectCreator().getStore(), salemodel.getSaleDetail());
            receiptString = Printer.print(receipt);
        }
        else
            return "Still " + Double.toString(salemodel.getSaleDetail().getRunningTotal()) + " left to pay";
        return receiptString;
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
        creator.getRegestryCreator().getSaleLog().logSale(salemodel.getSaleDetail());
    }


}

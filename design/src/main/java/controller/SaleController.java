package controller;

import model.PhysicalObjectCreator;
import model.item.Product;
import model.listener.saleprocess.SaleCartListener;
import model.listener.saleprocess.SaleListener;
import model.listener.saleprocess.SaleProgressListener;
import model.sale.Payment;
import service.saleservice.PaymentService;
import service.saleservice.SaleService;
import startup.ServiceFactory;

public class SaleController extends AbstractController{
    private PhysicalObjectCreator physicalObjectCreator;

    public SaleController(ServiceFactory serviceFactory) {
        super(serviceFactory);
        physicalObjectCreator = serviceFactory.getPhysicalObjectCreator();
    }


    public SaleService getSaleService() {
        return super.saleService;
    }

    public PaymentService getPaymentService() {
        return super.paymentService;
    }

    public void registerItem(Product product, int quantity) {
        saleService.registerItem(product, quantity);
    }

    /**
     * call saleModel to initialize a new sale opportunity.
     * The sale model will be created if it
     * hasn't been initialized or if the last sale has been completed
     * and logged.
     *
     */
    public void startSale() {
        saleService.startSale(super.modelListeners);
    }

    public void addSaleCartListener(SaleCartListener saleCartListener) {
        super.registerListeners(saleCartListener);
    }

    public void addSaleProgressListener(SaleProgressListener saleProgressListener) {
        super.registerListeners(saleProgressListener);
    }

    public void addSaleListener(SaleListener saleListener){
        super.registerListeners(saleListener);
    }

    /**
     * call saleModel to end the sale after all items has been registered
     *
     * @return message shown by the gui to present total cost
     */
    public void endSale() {
        super.saleService.endSale();
    }

    /**
     * call to the cash register to processes a payment
     *
     * @param amountPayed
     * @return returns information that is forwarded to a printer that prints a receipt
     */
    public String enterPayment(double amountPayed) {
        Payment payment = new Payment();
        payment.setAmountPayed(amountPayed);
        double change = paymentService.processPayment(physicalObjectCreator.getCashRegister(), payment);
        return saleService.finalizeSale();
    }

    /**
     * Method used to instruct object of <code> SaleService </code> class
     * to apply a calculated discount to current sale.
     *
     * @param
     * @return
     */

}

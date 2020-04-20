package controller;

import integration.datatransferobject.ItemDTO;
import model.discountmodel.Discount;
import model.itemmodel.Product;
import model.salemodel.Payment;
import model.salemodel.Sale;
import service.saleservice.PaymentService;
import service.saleservice.SaleService;
import startup.LayerCreator;

public class SaleController {

    private LayerCreator creator;
    private SaleService saleService;
    private PaymentService paymentService;

    public SaleController(LayerCreator creator) {
        this.creator = creator;
        this.saleService = new SaleService();
        this.paymentService = new PaymentService(saleService);
    }

    public LayerCreator getCreator() {
        return creator;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public String registerItem(Product product, int quantity) {
        return saleService.registerItem(product, quantity);
    }

    /**
     * call saleModel to initialize a new sale opportunity.
     * The sale model will be created if it
     * hasn't been initialized or if the last sale has been completed
     * and logged.
     *
     * @return message shown by the gui to confirm the start of a new sale
     */
    public String startSale() {
        saleService.startSale();
        String startConfirmation = "Sale Started";
        return startConfirmation;
    }

    /**
     * call saleModel to end the sale after all items has been registered
     *
     * @return message shown by the gui to present total cost
     */
    public Sale endSale() {
        return saleService.endSale();
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
        double change = paymentService.processPayment(creator.getPhysicalObjectCreator().getCashRegister(), payment);
        return saleService.finalizeSale();
    }

    /**
     * Method used to instruct object of <code> SaleService </code> class
     * to apply a calculated discount to current sale.
     *
     * @param
     * @return
     */
    public String applyDiscountToSale(Discount discount) {
        saleService.applyDiscountToSale(discount);
        return null;
    }


}

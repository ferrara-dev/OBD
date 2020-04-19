package view.cashierview;

import model.discountmodel.Discount;
import startup.LayerCreator;
import util.NotFoundException;
import view.View;



public class CashierView implements View {
    private LayerCreator creator;

    public CashierView(LayerCreator creator) throws Exception {
        this.creator = creator;
    }


    /**
     * call controller to initialize new sale
     */
    public void startSale() {
        creator.getSaleController().startSale();
    }

    public String endSale() {
        // call to controller
        return "Total cost : \n"
                + creator.getSaleController().endSale() + " kr";
    }

    /**
     * call controller to register an item to the sale
     *
     * @param itemId   the item identifier entered by the cashier
     * @param quantity quantity of the item being registered,
     *                 defaults as 1 if the cashier does not
     *                 specify the quantity.
     * @return message containing information about the sale, displayed by the gui
     */
    public String registerItem(int itemId, int quantity) {

            String displayMessage = creator.getItemController().registerItem(itemId, quantity);
            return displayMessage;
    }

<<<<<<< HEAD
    /**
     * Call to controller to initiate a discount request
     * @param customerId the id of the customer requesting a discount
     * @return information about the discount
     */
    public String signalDiscountRequest(String customerId) {
=======

    public Discount signalDiscountRequest(String customerId) {
>>>>>>> origin/master
            return creator.getDiscountController().signalDiscountRequest(customerId);
    }

    /**
     * Call to controller to initiate a payment
     * @param amount
     * @return
     */
    public String enterPayment(double amount){
        String saleDetails = creator.getSaleController().enterPayment(amount);
        return saleDetails;
    }

}

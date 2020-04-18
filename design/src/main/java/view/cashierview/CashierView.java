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


    public Discount signalDiscountRequest(String customerId) {
            return creator.getDiscountController().signalDiscountRequest(customerId);
    }


    public String enterPayment(double amount){
        String saleDetails = creator.getSaleController().enterPayment(amount);
        return saleDetails;
    }

}

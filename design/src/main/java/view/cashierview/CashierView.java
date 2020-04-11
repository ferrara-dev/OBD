package view.cashierview;

import startup.LayerCreator;
import view.View;
import view.cashierview.cashiergui.CashierGui;

public class CashierView implements View {
    private LayerCreator creator;
    private CashierGui cashierGui;

    public CashierView(LayerCreator creator) throws Exception {
        this.creator = creator;
        cashierGui = new CashierGui(this);
    }


    /**
     * call controller to initialize new sale
     */
    public void startSale(){
        displayMessage(creator.getSaleController().startSale());
    }

    public String endSale(){
        // call to controller
        return "Total cost : \n"
                + creator.getSaleController().endSale() + " kr";
    }

    /**
     * call controller to register a item to the sale
     * @param itemId the item identifier entered by the cashier
     * @param quantity quantity of the item being registered,
     *                 defaults as 1 if the cashier does not
     *                 specify the quantity.
     * @return message containing information about the sale, displayed by the gui
     */
    public String registerItem(int itemId, int quantity){
        String displayMessage = (creator.getItemController().registerItem(itemId, quantity));
        return displayMessage;
    }

    @Override
    public void displayMessage(String... message) {
        StringBuilder sb = new StringBuilder();
        for(String string: message){
            sb.append(string);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String signalDiscountRequest(String customerId){
        return  creator.getDiscountController().signalDiscountRequest(customerId);
    }

    public String enterPayment(double amount){
        String saleDetails = creator.getSaleController().enterPayment(amount);
        return saleDetails;
    }

}

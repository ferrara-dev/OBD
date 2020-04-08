package view.cashierview;

import startup.LayerCreator;
import view.View;

public class CashierView implements View {
    private LayerCreator creator;
    private CashierGui cashierGui;

    public CashierView(LayerCreator creator) throws Exception {
        this.creator = creator;
        cashierGui = new CashierGui(this);
    }

    public void startSale(){
        displayMessage(creator.getSaleController().startSale());
    }

    public String endSale(){
        // call to controller
        return "Total cost : \n"
                + creator.getSaleController().endSale() + " kr";
    }

    public String registerItem(int itemId, int quantity){
        //call to controller
        return (creator.getItemController().registerItem(itemId, quantity));

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
        creator.getSaleController().enterPayment(amount);
        return null;
    }

}

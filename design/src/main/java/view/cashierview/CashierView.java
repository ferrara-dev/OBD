package view.cashierview;

import controller.DiscountController;
import controller.SaleController;
import view.View;

public class CashierView implements View {
    private SaleController saleController;
    private CashierGui cashierGui;


    public CashierView(SaleController saleController) throws Exception {
        this.saleController = saleController;
        cashierGui = new CashierGui(this);
    }

    public void startSale(){
        displayMessage(saleController.startSale());
    }

    public String endSale(){
        // call to controller
        return "Total cost : \n"
                + saleController.endSale() + " kr";
    }

    public String registerItem(int itemId, int quantity){
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            System.out.println(ste);
        }
        //call to controller
        return (saleController.registerItem(itemId, quantity));

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
        return  saleController.discountController.signalDiscountRequest(customerId);
    }

}

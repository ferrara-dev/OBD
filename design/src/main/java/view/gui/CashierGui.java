package view.gui;


import view.AbstractViewHandler;
import view.gui.cashierview.saleview.ItemRegistrationView;
import view.gui.cashierview.saleview.SaleView;
import view.guiutil.SaleItemJTable;
import view.guiutil.GuiCreator;


public class CashierGui {
    /*
    SaleItemJTable saleItemJTable;
    private ViewHandler viewHandler;

    public CashierGui(GuiCreator guiCreator) throws Exception {


    }

    public SaleItemJTable getSaleItemJTable() {
        return saleItemJTable;
    }

    public AbstractViewHandler getViewHandler() {
        return viewHandler;
    }

    /**
     * Register an item and then goes on to update the text shown by the gui
     *
     * @param itemId
     * @param quantity
     */
    /*
    public void registerItem(int itemId, int quantity) {
            saleController.registerPropertyListener(viewHandler);
            saleController.getCreator().getItemController().registerItem(itemId, quantity);
    }

    /**
     * Ends the sale and switches card so that the secondDisplayPanel is displayed
     */
    /*
    public void endSale() {
        saleController.endSale();
    }

    /**
     * Switches the card so that the first displayPanel is displayed,
     * then starts the sale by calling cashierView
     */
    /*
    public void startSale() {
        saleController.registerPropertyListener(viewHandler);
        saleController.addSaleCartListener((ItemRegistrationView) viewHandler.getSaleView().getItemRegistrationView());
        saleController.addSaleProgressListener(viewHandler);
        saleController.addSaleListener((SaleView) viewHandler.getSaleView());
        saleController.startSale();
    }

    /**
     * initiates a discount request by calling
     * the cashierView.
     *
     * @param customerId identification number for whom
     *                   the discount is requested
     */
    //TODO: fixa så den anropas från SaleProcessView
    /*
    public void signalDiscount(String customerId) {
        discountController.signalDiscountRequest(customerId);
    }

    /**
     * Call to cashierView to enter the payment made by the customer,
     * goes on to update the text on <code>secondDisplayPanel</code>
     */
    /*
    public void enterPayment() {
        // TODO: FIXA så den anropas från SaleProcessView
        saleController.enterPayment(100);
    }
    */
}


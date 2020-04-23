package view.guiutil;


import controller.ControllerFactory;
import view.gui.ViewHandler;
import view.gui.cashierview.AfterSaleView;
import view.gui.cashierview.startsaleview.StartSaleView;
import view.gui.cashierview.PaymentView;
import view.gui.cashierview.saleview.SaleView;

/**
 * Factory class that creates and holds/distributes references to the sale process views
 */
public class ViewFactory  {

    private StartSaleView startSaleView;
    private PaymentView paymentView;
    private AfterSaleView afterSaleView;
    private SaleView saleView;
    private ControllerFactory controllerFactory;
    private ViewHandler viewHandler;

    public ViewFactory(ControllerFactory controllerFactory){
        this.controllerFactory = controllerFactory;
        startSaleView = new StartSaleView(this);
        saleView = new SaleView(this);
        paymentView = new PaymentView();
        afterSaleView = new AfterSaleView();
        viewHandler = new ViewHandler(this);
    }

    public ViewHandler getViewHandler() {
        return viewHandler;
    }

    public ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

    public AfterSaleView getAfterSaleView() {
        return afterSaleView;
    }

    public StartSaleView getStartSaleView() {
        return startSaleView;
    }

    public PaymentView getPaymentView() {
        return paymentView;
    }

    public SaleView getSaleView() {
        return saleView;
    }

}

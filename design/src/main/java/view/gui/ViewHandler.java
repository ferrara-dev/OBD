package view.gui;

import model.listener.saleprocess.SaleProgressListener;
import view.AbstractViewHandler;
import view.gui.cashierview.*;
import view.gui.cashierview.saleview.ItemRegistrationView;
import view.gui.cashierview.startsaleview.StartSaleView;
import view.guiutil.ViewFactory;

import java.awt.*;



public class ViewHandler extends AbstractViewHandler implements SaleProgressListener {


    public ViewHandler(ViewFactory viewFactory) {
        super(viewFactory);
        setLayout(new CardLayout());
        add(viewFactory.getStartSaleView(), StartSaleView.CARD_CONSTRAINT);
        add(viewFactory.getSaleView(), ItemRegistrationView.CARD_CONSTRAINT);
        add(viewFactory.getPaymentView(), PaymentView.CARD_CONSTRAINT);
    }

    @Override
    public void SaleHasStarted(boolean active) {
        if(active == true){
            CardLayout cl = (CardLayout) (this.getLayout());
            cl.show(this, ItemRegistrationView.CARD_CONSTRAINT);
        }
    }

    @Override
    public void SaleHasEnded(boolean completed) {
        if(completed == true){
            CardLayout cl = (CardLayout) (this.getLayout());
            cl.show(this, PaymentView.CARD_CONSTRAINT);
        }
    }

    @Override
    public void SaleIsPayed(boolean active) {
        if(active == false){

        }
    }
}

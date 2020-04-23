package view;

import controller.*;
import model.listener.ModelListener;
import view.gui.ViewHandler;
import view.gui.cashierview.saleview.SaleView;
import view.guiutil.ViewFactory;

import javax.swing.*;



public abstract class AbstractViewHandler extends JPanel implements ModelListener {
    private ViewFactory viewFactory;

    public AbstractViewHandler (ViewFactory viewFactory){
        this.viewFactory = viewFactory;
    }

    protected SaleController getSaleController(){
        return viewFactory.getControllerFactory().getSaleController();
    }

    protected ItemController getItemController(){
        return viewFactory.getControllerFactory().getItemController();
    }

    protected DiscountController getDiscountController(){
        return viewFactory.getControllerFactory().getDiscountController();
    }

    protected SaleView getSaleView(){
        return viewFactory.getSaleView();
    }

    protected ViewHandler getViewHandler(){
        return viewFactory.getViewHandler();
    }
}

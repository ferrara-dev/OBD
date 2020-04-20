package view.cashierview;

import view.cashierview.cashiergui.panels.GuiCreator;

public class PropertyListenerFactory {
    public final SaleItemPropertyListener saleItemPropertyListener;

    public PropertyListenerFactory(GuiCreator creator){
        saleItemPropertyListener =  new SaleItemPropertyListener(creator);
    }
}

package view.cashierview;

import view.View;
import view.cashierview.cashiergui.CashierGui;
import view.cashierview.cashiergui.panels.GuiCreator;

import java.beans.PropertyChangeEvent;

public class SaleItemPropertyListener extends View {
    CashierGui cashierGui;
    SaleItemView saleItemView;

    public SaleItemPropertyListener(GuiCreator guiCreator){
        cashierGui = guiCreator.getCashierGui();
        saleItemView= new SaleItemView(this);
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {

    }

    //  Use this to observe property changes from registered models
    //  and propagate them on to all the views.

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for(int i = 0; i < cashierGui.getCustomJTable().getMyList().getSize(); i++){
            if(evt.getSource() == cashierGui.getCustomJTable().getMyList().getElementAt(i)){
                int column = 1;
                if(evt.getPropertyName() == "totalPrice")
                    column = 2;
                cashierGui.getCustomJTable().getTableModel().setMyList(cashierGui.getCustomJTable().getMyList());

                return;
            }

        }

       // saleItemView.itemBeanTableModel.;

        System.out.println("Name = " + evt.getPropertyName());

        System.out.println("Old Value = " + evt.getOldValue());

        System.out.println("New Value = " + evt.getNewValue());

        System.out.println("**********************************");
    }
}

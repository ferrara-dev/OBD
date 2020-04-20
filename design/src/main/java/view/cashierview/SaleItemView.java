package view.cashierview;

import model.itemmodel.Product;
import model.salemodel.SaleItem;
import view.View;
import view.cashierview.cashiergui.CashierGui;
import view.cashierview.io.BeanTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleItemView implements ActionListener {
    View view;
    BeanTableModel<SaleItem> itemBeanTableModel;
    JButton itemUppdater;
    JButton itemAdder;
    CashierGui cashierGui;

    public SaleItemView(SaleItemPropertyListener saleItemPropertyListener){
        cashierGui = saleItemPropertyListener.cashierGui;
        view = saleItemPropertyListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == itemUppdater) {

        }

        if(e.getSource() == itemAdder) {
            cashierGui.registerItem(1,2);
        }
    }
}

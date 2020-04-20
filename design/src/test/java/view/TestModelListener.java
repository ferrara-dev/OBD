package view;

import integration.DataBaseHandler;
import integration.datatransferobject.ItemDTO;
import integration.productdb.InventoryHandler;
import model.itemmodel.Product;

import model.salemodel.Sale;
import model.salemodel.SaleItem;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;
import view.cashierview.PropertyListenerFactory;
import view.cashierview.cashiergui.CashierGui;
import view.cashierview.cashiergui.panels.GuiCreator;
import view.cashierview.io.BeanTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestModelListener implements ActionListener {
    JButton jButton;
    SaleItem saleItem;

    @Before
    public void setUp() throws Exception {
        jButton = new JButton("increase quantity");
        jButton.addActionListener(this::actionPerformed);
        DataBaseHandler<ItemDTO, Integer> handler = new InventoryHandler();
        Product one = new Product();
        one.setAttributes(handler.collect("1"));
        saleItem = new SaleItem(one);
    }

    @Test
    public void testModelListener() throws Exception {
        GuiCreator creator = new GuiCreator(new CashierGui(new LayerCreator()));

        saleItem.addPropertyChangeListener(creator.getPropertyListenerFactory().saleItemPropertyListener);
        saleItem.update(1);
        BeanTableModel<SaleItem> tableModel = new BeanTableModel<SaleItem>(SaleItem.class);


        while(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            saleItem.update(1);
        }
    }
}

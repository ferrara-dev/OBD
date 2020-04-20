package view;

import integration.DataBaseHandler;
import integration.datatransferobject.ItemDTO;
import integration.productdb.InventoryHandler;
import model.itemmodel.Product;
import model.salemodel.Sale;
import model.salemodel.SaleItem;
import org.junit.Before;
import org.junit.Test;
import view.cashierview.CashierView;
import view.cashierview.io.BeanTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBeanTable implements ActionListener {
    JButton itemAdder;
    DataBaseHandler<ItemDTO, Integer> handler;
    BeanTableModel<SaleItem> model;
    SaleItem saleItem;
    CashierView cashierView;
    @Before
    public void setUp() throws Exception {
        handler = new InventoryHandler();

        Product one = new Product();
        one.createItemModel(handler.collect("1"));
        Product two = new Product();
        two.createItemModel(handler.collect("2"));
        Product three = new Product();
        three.createItemModel(handler.collect("2"));
        saleItem = new SaleItem(one);
        //    InputButton one = new CardSwitchingButton("One");
        //   InputButton two = new RegistrationButton("Two");
        //   InputButton three = new RegistrationButton("Three");

        //  Use the custom model

        //  JButtonTableModel model = new JButtonTableModel();

        //  Use the BeanTableModel
        cashierView = new CashierView(model);
        saleItem.addPropertyChangeListener(cashierView);

        model =
                new BeanTableModel<SaleItem>(SaleItem.class);

        model.addRow(saleItem);

        model.setColumnEditable(1, false);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel south = new JPanel();
        itemAdder = new JButton();

        itemAdder.addActionListener(this::actionPerformed);
        south.add(itemAdder);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(south, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true);
    }

    @Test
    public void testBeanTableModel() throws Exception {


       // assertNotEquals(rowCount,secondRowCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemAdder) {
            Product newItem = new Product();
            newItem.createItemModel(handler.collect("1"));
            saleItem.update(1);
        }
    }
}

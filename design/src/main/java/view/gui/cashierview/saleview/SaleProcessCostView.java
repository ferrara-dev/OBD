package view.gui.cashierview.saleview;

import model.discount.Discount;
import model.item.SaleItemTableModel;
import model.listener.saleprocess.SaleListener;
import model.sale.Cost;
import view.AbstractViewHandler;
import view.guiutil.ViewFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SaleProcessCostView extends AbstractViewHandler implements SaleListener {
    JTable jTable;
    DefaultTableModel defaultTableModel;

    public SaleProcessCostView(ViewFactory viewFactory) {
        super(viewFactory);
        defaultTableModel = new DefaultTableModel(new String[]{"Running total", "Total VAT"} , 1) ;
        defaultTableModel.setValueAt(0,0,0);
        defaultTableModel.setValueAt(0,0,1);
        jTable = new JTable(defaultTableModel);

        jTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(380,280));
        add(scrollPane);
    }


    @Override
    public void runningTotalHasChanged(double runningTotal) {

    }

    @Override
    public void discountWasApplied(Discount appliedDiscount) {

    }

    @Override
    public void costHasChanged(Cost IncreasedCost) {

    }

}

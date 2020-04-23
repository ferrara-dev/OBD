package view.gui.cashierview.saleview;


import model.discount.PriceDiscountTableModel;
import model.discount.ProductDiscountTableModel;
import model.discount.discounttypes.itemdiscount.ItemDiscount;
import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.item.SaleItem;
import model.item.SaleItemTableModel;
import model.listener.saleprocess.DiscountListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class DiscountView extends JPanel implements DiscountListener {
    ItemDiscountJTable jTable;

    public DiscountView (){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new MigLayout("fill"));
        jTable = new ItemDiscountJTable();
        add(jTable.panel, "push,grow");
    }


    @Override
    public void itemDiscountWasApplied(List<ItemDiscount> appliedItemDiscount) {

    }

    @Override
    public void priceDiscountWasApplied(List<PriceDiscount> appliedPriceDiscount) {

    }

    @Override
    public void discountWasApplied(double totalPriceReduction) {

    }

    public class ItemDiscountJTable implements ActionListener {
        private ProductDiscountTableModel tableModel;
        private PriceDiscountTableModel priceDiscountTableModel;
        JPanel panel;
        private JTable table;
        private JTable table1;

        public ItemDiscountJTable() {
            panel = new JPanel();
            tableModel = new ProductDiscountTableModel();
            priceDiscountTableModel = new PriceDiscountTableModel();
            table = new JTable(tableModel);
            table1 = new JTable(priceDiscountTableModel);
            table1.setAutoCreateRowSorter(true);
            table.setAutoCreateRowSorter(true);
            JScrollPane scrollPane = new JScrollPane(table);
            JScrollPane scrollPane1 = new JScrollPane(table1);
            scrollPane1.setPreferredSize(new Dimension(300,280));
            scrollPane.setPreferredSize(new Dimension(380,280));
            panel.add(scrollPane);
            panel.add(scrollPane1);
        }

        // public void setTableModel(SaleItemTableModel tableModel) {
        //      this.tableModel = tableModel;
        //  }

        public ProductDiscountTableModel getTableModel() {
            return tableModel;
        }

        public JPanel getPanel() {
            if(panel == null)
                panel = new JPanel();
            return panel;
        }

        public void setTableModel(SaleItemTableModel saleItemTableModel){
            table.setModel(saleItemTableModel);
        }

        public java.util.List<SaleItem> getCart() {
            return tableModel.getDataModel();
        }

        public void setCard(List<ItemDiscount> myList) {
            tableModel.setList(myList);
        }

        public JTable getTable() {
            return table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}

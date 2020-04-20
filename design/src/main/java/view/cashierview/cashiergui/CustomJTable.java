package view.cashierview.cashiergui;

import model.CustomListModel;
import model.salemodel.Cart;
import model.salemodel.SaleItem;
import javax.swing.*;
import javax.swing.event.RowSorterEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomJTable implements ActionListener {
    private SimpleSaleItemTableModel tableModel;
    JPanel panel;
    private JTable table;
    private CustomListModel<SaleItem> myList;
    public CustomJTable() {
    }

    public void createDefault(Cart cart){
        myList = cart.getItems();
        tableModel = new SimpleSaleItemTableModel(myList);

        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,280));
        panel.add(scrollPane);
    }

    public void setTableModel(SimpleSaleItemTableModel tableModel) {

        this.tableModel = tableModel;
    }

    public SimpleSaleItemTableModel getTableModel() {
        return tableModel;
    }

    public JPanel getPanel() {
        if(panel == null)
            panel = new JPanel();
        return panel;
    }

    public CustomListModel<SaleItem> getMyList() {
        return myList;
    }

    public void setMyList(CustomListModel<SaleItem> myList) {
        this.myList = myList;
    }

    public JTable getTable() {
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

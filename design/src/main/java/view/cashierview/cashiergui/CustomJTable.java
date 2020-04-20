package view.cashierview.cashiergui;

import model.salemodel.Cart;
import model.salemodel.SaleItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomJTable implements ActionListener {
    private SimpleSaleItemTableModel tableModel;
    JPanel panel;
    private JTable table;
    private List<SaleItem> list;

    public CustomJTable() {
        panel = new JPanel();
        tableModel = new SimpleSaleItemTableModel();
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,280));
        panel.add(scrollPane);
    }

    public void createDefault(Cart cart){
        list = cart.getItems();

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

    public List<SaleItem> getCart() {
        return list;
    }

    public void setCard(List<SaleItem> myList) {
        this.list = myList;
        tableModel.setList(myList);
    }

    public JTable getTable() {
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

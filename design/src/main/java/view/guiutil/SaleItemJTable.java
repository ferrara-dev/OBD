package view.guiutil;

import model.item.SaleItemTableModel;
import model.item.SaleItem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SaleItemJTable implements ActionListener {
    private SaleItemTableModel tableModel;
    JPanel panel;
    private JTable table;

    public SaleItemJTable() {
        panel = new JPanel();
        tableModel = new SaleItemTableModel();
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,280));
        panel.add(scrollPane);
    }

   // public void setTableModel(SaleItemTableModel tableModel) {
  //      this.tableModel = tableModel;
  //  }

    public SaleItemTableModel getTableModel() {
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

    public List<SaleItem> getCart() {
        return tableModel. getDataList();
    }

    public void setCard(List<SaleItem> myList) {
        tableModel.setList(myList);
    }

    public JTable getTable() {
        return table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

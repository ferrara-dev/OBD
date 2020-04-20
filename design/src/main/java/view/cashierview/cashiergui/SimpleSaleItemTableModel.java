package view.cashierview.cashiergui;

import model.salemodel.SaleItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class SimpleSaleItemTableModel extends AbstractTableModel {
    private String[] columnNames = {"Product", "Price", "Quantity"};
    private List<SaleItem> list;

    public SimpleSaleItemTableModel() {
        this.list = new ArrayList<>();
    }

    public void addElement(SaleItem element) {
        list.add(element);
        int index = list.size();
        fireTableCellUpdated(index,index);
    }


    public int getSize() {
        return list.size();
    }

    public SaleItem getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(SaleItem element) {
        list.remove(element);
        int index = list.size();
        fireTableCellUpdated(index,index);
    }


    public int getColumnCount() {
        return columnNames.length;
    }

    public void setList(List<SaleItem> myList) {
        this.list = myList;
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Indicate the change has happened:
        super.setValueAt(aValue, rowIndex, columnIndex);
        fireTableDataChanged();
    }

    public int getRowCount() {
        int size;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = getElementAt(row).getProduct().getName();
        } else if (col == 1) {
            temp = getElementAt(row).getTotalPrice();
        } else if (col == 2) {
            temp = (double) getElementAt(row).getQuantity();
        }
        return temp;
    }

    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 2 || col ==1) {
            return Double.class;
        } else {
            return String.class;
        }
    }
}


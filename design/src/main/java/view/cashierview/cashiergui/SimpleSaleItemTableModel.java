package view.cashierview.cashiergui;

import model.CustomListModel;
import model.salemodel.SaleItem;

import javax.swing.table.AbstractTableModel;


public class SimpleSaleItemTableModel extends AbstractTableModel {
    private String[] columnNames = {"Product", "Price", "Quantity"};
    private CustomListModel<SaleItem> myList;

    public SimpleSaleItemTableModel(CustomListModel<SaleItem> myList) {
        this.myList = myList;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void setMyList(CustomListModel<SaleItem> myList) {
        this.myList = myList;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Indicate the change has happened:
        fireTableDataChanged();
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    public int getRowCount() {
        int size;
        if (myList == null) {
            size = 0;
        } else {
            size = myList.getSize();
        }
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = myList.getElementAt(row).getProduct().getName();
        } else if (col == 1) {
            temp = myList.getElementAt(row).getTotalPrice();
        } else if (col == 2) {
            temp = (double) myList.getElementAt(row).getQuantity();
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


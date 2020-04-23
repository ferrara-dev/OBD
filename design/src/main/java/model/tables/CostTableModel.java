package model.tables;

import model.sale.Cost;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CostTableModel extends AbstractTableModel {

    private String[] columnNames = {"Total Cost", "Total VAT"};
    protected List<Cost> list;


    public CostTableModel() {
        this.list = new ArrayList<>();
    }

    public void addElement(Cost element) {
        list.add(element);
        int index = list.size();
        fireTableCellUpdated(index, index);
    }

    public void addElementAt(int row, Cost element) {
        list.remove(row);
        list.add(row, element);
        fireTableCellUpdated(row, row);
    }

    public int getSize() {
        return list.size();
    }

    public Cost getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(Cost element) {
        list.remove(element);
        int index = list.size();
        fireTableCellUpdated(index, index);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableChanged(new TableModelEvent(this));
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void setList(List<Cost> myList) {
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
         //   temp = getElementAt(row).getDiscountRate();
        } else if (col == 1) {
       //     temp = getElementAt(row).getTotalPriceReduction();
        }
        return temp;
    }

    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 1 || col == 0) {
            return Double.class;
        } else {
            return String.class;
        }
    }

    public List getDataList() {
        return list;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}


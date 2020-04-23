package model.discount;

import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.item.SaleItem;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class PriceDiscountTableModel extends AbstractTableModel {
    private String[] columnNames = {"Discount rate", "Total discount on price"};
    protected List<PriceDiscount> list;


    public PriceDiscountTableModel() {
        this.list = new ArrayList<>();
    }

    public void addElement(PriceDiscount element) {
        list.add(element);
        int index = list.size();
        fireTableCellUpdated(index,index);
    }

    public void addElementAt(int row, PriceDiscount element){
        list.remove(row);
        list.add(row,element);
        fireTableCellUpdated(row,row);
    }
    public int getSize() {
        return list.size();
    }

    public PriceDiscount getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(SaleItem element) {
        list.remove(element);
        int index = list.size();
        fireTableCellUpdated(index,index);
    }

    @Override
    public void fireTableDataChanged(){
        super.fireTableChanged(new TableModelEvent(this));
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void setList(List<PriceDiscount> myList) {
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
            temp = getElementAt(row).getDiscountRate();
        } else if (col == 1) {
            temp = getElementAt(row).getTotalPriceReduction();
        }
        return temp;
    }

    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 1 || col ==0) {
            return Double.class;
        } else {
            return String.class;
        }
    }

    public List getDataList(){
        return list;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){

    }
}

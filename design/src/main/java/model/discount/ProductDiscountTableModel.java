package model.discount;

import model.discount.discounttypes.itemdiscount.ItemDiscount;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductDiscountTableModel extends AbstractTableModel {
    private String[] columnNames = {" Discounted products ", " Deal ", " Total discount on price "};
    protected List<ItemDiscount> list;

    public ProductDiscountTableModel(List<ItemDiscount> list) {
        this.list = list;
    }

    public ProductDiscountTableModel() {

    }
    public List getDataModel(){
        return list;
    }

    public void setList(List<ItemDiscount> myList){
        this.list = myList;
        fireTableDataChanged();
    }
    public void addElement(ItemDiscount element) {
        list.add(element);
        int index = list.size();
        fireTableDataChanged();
    }

    @Override
    public void fireTableDataChanged(){
        super.fireTableChanged(new TableModelEvent(this));
    }

    public void fireDateChanged() {
        int index = list.size();
        fireTableDataChanged();
    }

    public int getSize() {
        return list.size();
    }

    public ItemDiscount getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(ItemDiscount element) {
        list.remove(element);
        int index = list.size();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int size;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
        //    temp = getElementAt(row).getDiscountedItems().getName();
        } else if (col == 1) {
           // temp = getElementAt(row).get;
        } else if (col == 2) {
            temp = (double) getElementAt(row).getTotalPriceReduction();
        }
        return temp;
    }
}

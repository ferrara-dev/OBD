package view.cashierview.io.saleio;

import javax.swing.*;
import java.util.List;

public class CustomSaleModelList<Sale> extends AbstractListModel <Sale> {
    protected List <Sale> list;

    public CustomSaleModelList(List <Sale> list) {
        this.list = list;

    }

    public CustomSaleModelList() {
    }


    public void addElement(Sale sale) {
        list.add(sale);
        int index = list.size();
        fireContentsChanged(sale,index,index);
    }

    public void fireDateChanged() {
        int index = list.size();
        fireContentsChanged(list.get(index-1), index,index);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public Sale getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(Sale sale) {
        list.remove(sale);
        int index = list.size();
        fireContentsChanged(sale,index,index);
    }



}

package model.salemodel;

import model.AbstractModel;
import model.CustomListModel;
import model.itemmodel.Product;
import util.NotFoundException;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.Objects;

public class Cart extends AbstractModel {
    CustomListModel<SaleItem> items;

    private PropertyChangeSupport pcs;

    public Cart() {
        items = new CustomListModel<SaleItem>();
        pcs = new PropertyChangeSupport(items);
    }

    public CustomListModel<SaleItem> getItems() {
        return items;
    }

    public int size(){
        if(Objects.nonNull(items))
            return items.getSize();
        return 0;
    }

    public void add(Product product, int quantity) {
        SaleItem saleItem;
        try {
            saleItem = find(product);
            saleItem.update(quantity);

        } catch (NotFoundException e) {
            if(Objects.nonNull(product)) {
                saleItem = new SaleItem(product);
                items.addElement(saleItem);
            }
        }
    }

    public SaleItem find(Product product) {
        if(Objects.nonNull(product))
            if(Objects.nonNull(items))
            for (int i = 0; i < items.getSize(); i++) {
                if (items.getElementAt(i).getProduct().equals(product)) {
                    return items.getElementAt(i);
                }
            }
        throw new NotFoundException("not found in cart");
    }

    public SaleItem get(int index){
        return items.getElementAt(index);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

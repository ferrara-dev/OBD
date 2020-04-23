package model.sale;

import model.AbstractModel;
import model.discount.discounttypes.itemdiscount.ItemDiscount;
import model.item.Product;
import model.item.SaleItem;
import model.listener.saleprocess.SaleCartListener;
import util.NotFoundException;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;

public class Cart extends AbstractModel {
    private ArrayList<ItemDiscount> itemDiscounts;
    private ArrayList<SaleItem> items;
    SaleCartListener saleCartListener;
    private int listSize = 0;

    public Cart() {
        items = new ArrayList<>();
        super.firePropertyChange("items", null, items);
    }

    public void addItemDiscounts(ItemDiscount itemDiscount){
        if(itemDiscount == null)
            itemDiscounts = new ArrayList<>();

    }
    public ArrayList<SaleItem> getItems() {
        return items;
    }

    public int size() {
        if (Objects.nonNull(items))
            return items.size();
        return 0;
    }

    public void add(Product product, int quantity) {
        ArrayList<SaleItem> oldValue = items;
        SaleItem saleItem;
        try {
            saleItem = find(product);
            saleItem.update(quantity);
            saleCartListener.saleItemListChanged(items);
            super.firePropertyChange("items", oldValue, items);
        } catch (NotFoundException e) {
            if (Objects.nonNull(product)) {
                saleItem = new SaleItem(product);
                saleItem.addPropertyChangeListener(super.getPropertyChangeListeners());
                items.add(saleItem);
                saleCartListener.saleItemListChanged(items);
                super.firePropertyChange("listSize", this.listSize, items.size());
                listSize ++;
            }
        }
    }

    public SaleItem find(Product product) {
        if (Objects.nonNull(product))
            if (Objects.nonNull(items))
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getProduct().equals(product)) {
                        return items.get(i);
                    }
                }
        throw new NotFoundException("not found in cart");
    }

    public SaleItem getItem(int itemId){
            if (Objects.nonNull(items))
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getProduct().getItemId() == itemId) {
                        return items.get(i);
                    }
                }
        throw new NotFoundException("not found in cart");
    }

    public SaleItem get(int index) {
        return items.get(index);
    }

    public void addSaleCartListener(SaleCartListener saleCartListener){
        this.saleCartListener = saleCartListener;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
    }
}

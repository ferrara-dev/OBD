package model.salemodel;

import model.itemmodel.Product;
import util.NotFoundException;

import java.util.ArrayList;
import java.util.Objects;

public class Cart  {
    ArrayList<SaleItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<SaleItem> getItems() {
        return items;
    }

    public int size(){
        if(Objects.nonNull(items))
            return items.size();
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
                saleItem.setQuantity(quantity);
                items.add(saleItem);
            }
        }
    }

    public SaleItem find(Product product) {
        if(Objects.nonNull(product))
            if(Objects.nonNull(items))
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getProduct().equals(product)) {
                    return items.get(i);
                }
            }
        throw new NotFoundException("not found in cart");
    }

    public SaleItem get(int index){
        return items.get(index);
    }

}

package model.salemodel;

import model.CustomListModel;
import model.itemmodel.Product;
import util.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart extends CustomListModel<SaleItem> {

    public Cart(List<SaleItem> list) {
        super(list);
    }


    public void add(Product product, int quantity) {
        SaleItem saleItem;
        try {
            saleItem = find(product);
            saleItem.update(quantity);

        } catch (NotFoundException e) {
            if(Objects.nonNull(product)) {
                saleItem = new SaleItem(product);
                addElement(saleItem);
            }
        }
    }

    public SaleItem find(Product product) {
        if(Objects.nonNull(product))
            for (int i = 0; i < getSize(); i++) {
                if (getElementAt(i).getProduct().equals(product)) {
                    return getElementAt(i);
                }
            }
        throw new NotFoundException("not found in cart");
    }

}

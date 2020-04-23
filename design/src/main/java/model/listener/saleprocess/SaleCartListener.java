package model.listener.saleprocess;
import model.item.SaleItem;
import model.listener.ModelListener;

import java.util.List;

public interface SaleCartListener extends ModelListener {
    void saleItemListChanged(List<SaleItem> registredItems);
    void saleItemStateUpdated(SaleItem saleItem, int row);

}

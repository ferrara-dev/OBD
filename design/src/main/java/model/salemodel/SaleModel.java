package model.salemodel;


import integration.ItemDetail;
import integration.RegestryCreator;
import model.itemmodel.ItemModel;
import util.NotFoundException;

import java.util.Objects;

public class SaleModel {
    private SaleDetail saleDetail;
    private final int ITEM_NOT_FOUND = 0;

    public SaleModel() {

    }

    /**
     * Gets details about current sale.
     * First check if saleDetail has not
     * been initiated.
     *
     * @return details about current sale
     */
    public SaleDetail getSaleDetail() {
        if (Objects.isNull(saleDetail)) {
            startSale();
        }
        return saleDetail;
    }

    /**
     * Call to the integration layer to fetch information about an item register an item
     *
     * @param
     * @param
     * @return
     */

    public String registerItem(ItemModel itemModel) {
        if (Objects.isNull(saleDetail)) {
            startSale();
        }

        if (!saleDetail.isCompleted())
            if (saleDetail.isActive()) {
                String saleDetails = saleDetail.addItemToSale(itemModel);
                return saleDetails;
            }
        return getDisplayMessage(ITEM_NOT_FOUND, false);
    }

    public void setSaleDetail(SaleDetail saleDetail) {
        this.saleDetail = saleDetail;
    }

    /**
     * Creates a new sale detail where all information about
     * the performed transaction is stored.
     */
    public void startSale() {
        saleDetail = new SaleDetail();
    }

    public String endSale() {
        return Double.toString(saleDetail.completeSale());
    }

    private String getDisplayMessage(int itemId, boolean itemFound) {
        if (itemFound) {
            return " ";
        }

        return "Item not found";
    }

}

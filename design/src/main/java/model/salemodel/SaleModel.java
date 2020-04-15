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
                saleDetail.setSaleLineItem(itemModel);
                String saleDetails = addItemToSale();
                return saleDetails;
            }
        return getDisplayMessage(ITEM_NOT_FOUND, false);
    }

    /**
     * fetch information about an item from the item registry
     * throws ItemNotFoundException if the item is not found.
     *
     * @param itemId
     * @return Detailed information about the item with the
     * given itemIdentifier

    private ItemDetail fetchItemDetail(int itemId) {
        if (!creator.getItemRegestry().contains(itemId))
            throw new NotFoundException("Item not found");
        return creator.getItemRegestry().getItemDetail(itemId);
    }
   */

    /**
     * Creates a new sale detail where all information about
     * the performed transaction is stored.
     */
    public void startSale() {
        saleDetail = new SaleDetail();
    }

    public String endSale() {
        saleDetail.completeSale();
        return Double.toString(saleDetail.getTotalCost());
    }

    private String getDisplayMessage(int itemId, boolean itemFound) {
        if (itemFound) {
            return " ";
        }

        return "Item not found";
    }

    private String addItemToSale() {
        String saleDetails = saleDetail.updateSaleDetail();
        return saleDetails;
    }


}

package model.salemodel;


import integration.ItemDetail;
import integration.RegestryCreator;
import model.Calendar;
import model.itemmodel.ItemModel;
import model.Model;

public class SaleModel implements Model {
    public SaleDetail saleDetail;
    public RegestryCreator creator;

    private final int ITEM_NOT_FOUND = 0;

    public SaleModel(RegestryCreator creator) {
        this.creator = creator;
    }

    /**
     * Call to the integration layer to fetch information about an item register an item
     * @param itemId
     * @param quantity
     * @return
     */
    @Override
    public String registerItem(int itemId, int quantity) {
        boolean isRegistered = false;
        if(!saleDetail.isCompleted())
        if(creator.getItemRegestry().contains(itemId)) {
            if (saleDetail.isActive() && new ItemModel(fetchItemDetail(itemId), quantity) != null) {
                saleDetail.setSaleLineItem(new ItemModel(creator.getItemRegestry().getItemDetail(itemId), quantity));
                String saleDetails = addItemToSale();
                return saleDetails;
            }
        }
            return getDisplayMessage(ITEM_NOT_FOUND, false);
    }

    /**
     * fetch information about an item
     * @param itemId
     * @return
     */
    private ItemDetail findItem(int itemId){
        if(!creator.getItemRegestry().contains(itemId))
            throw new Illegal("No such item found in inventory");
        return creator.getItemRegestry().getItemDetail(itemId);
    }

    /**
     * Creates a new sale detail where all information about
     * the performed transaction is stored.
     */
    public void startSale() {
        saleDetail = new SaleDetail();
    }

    public String endSale() {
        saleDetail.setCompleted(true);
        saleDetail.setTimeAndDateOfSale(Calendar.getTimeAndDate());
        return Double.toString(saleDetail.getRunningTotal());
    }

    public String paySale(){
        return null;
    }
    private String getDisplayMessage(int itemId, boolean itemFound) {
        if(itemFound) {


            return " ";
        }

        return "Item not found";
    }

    private String addItemToSale(){
       String saleDetails = saleDetail.updateSaleDetail();
       return saleDetails;
    }


}

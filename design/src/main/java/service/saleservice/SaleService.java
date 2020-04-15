package service.saleservice;

import model.itemmodel.ItemModel;
import model.salemodel.SaleDetail;
import model.salemodel.SaleModel;

public class SaleService {
    SaleModel saleModel;

    public SaleService(SaleModel saleModel){
        this.saleModel = saleModel;
    }
    /**
     * Creates a new sale detail where all information about
     * the performed transaction is stored.
     */
    public void startSale() {
        saleModel.setSaleDetail(new SaleDetail());
    }

}

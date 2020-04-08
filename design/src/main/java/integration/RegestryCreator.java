package integration;

import integration.discountdb.DiscountDB;
import integration.productdb.ProductDB;

public class RegestryCreator {
     ItemRegestry itemRegestry;
     DiscountRegestry discountRegestry;
     SaleLog saleLog;

    static final String [] DISCOUNT_TYPES = {"2-for-1","10% off", ""};

    public RegestryCreator() throws Exception {
        createItemRegestry();
        createDiscountRegestry();
    }

    private void createItemRegestry() throws Exception {
        ProductDB db = new ProductDB();
        db.load();
        itemRegestry = new ItemRegestry(db.createProductList());
        saleLog = new SaleLog();
    }

    public SaleLog getSaleLog(){
        return saleLog;
    }

    public ItemRegestry getItemRegestry() {
        return itemRegestry;
    }

    public DiscountRegestry getDiscountRegestry(){
        return discountRegestry;
    }

    private void createDiscountRegestry() throws Exception {
        DiscountDB db = new DiscountDB();
        db.load();
        //DiscountOffer ProductDiscount1 = new DiscountOffer("product",1,{})
       discountRegestry = new DiscountRegestry(db.createDiscountList());
    }


}

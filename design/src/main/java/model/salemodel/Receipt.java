package model.salemodel;

import model.Paper;
import model.Store;


import java.text.DecimalFormat;


public class Receipt implements Paper {
    public String storeName;
    public String storeAddress;
    public String CustomerServicePhoneNumber;
    public String CustomerServiceEmailAddress;

    public String timeAndDateOfSale;
    public String [] purchasedItems;
    public String totalCost;
    public String totalTaxPayed;
    public String amountPaid;
    public String change;
    public String [] itemNames;
    public String [] itemPrices;
    public String [] itemVats;
    public String [] itemQuantites;
    public final String [] paymentInformation = {"Total cost : " + totalCost, "Amount paid : " + amountPaid, "change : " + change, "total VAT : " + totalTaxPayed};
    private DecimalFormat df2 = new DecimalFormat("#.##");
    public Receipt(Payment payment, Store store, SaleDetail saleDetail)
    {
        timeAndDateOfSale = saleDetail.getTimeAndDateOfSale();
        int length = saleDetail.getProcessedGoods().getGoods().size();
        System.out.println(length);
        totalTaxPayed = Double.toString(saleDetail.getTotalVAT());
        purchasedItems = new String[length];
        itemNames = new String[length];
        itemVats = new String[length];
        itemPrices = new String[length];
        itemQuantites = new String[length];

        for(int i = 0; i < length; i++){
            itemNames[i] = saleDetail.getProcessedGoods().getGoods().get(i).name;
            itemPrices[i] = df2.format( saleDetail.getProcessedGoods().getGoods().get(i).price);
            itemQuantites[i] = (Double.toString(saleDetail.getProcessedGoods().getGoods().get(i).quantity));
            itemVats[i] = df2.format(saleDetail.getProcessedGoods().getGoods().get(i).price*(saleDetail.getProcessedGoods().getGoods().get(i).taxRate));
        }

        totalTaxPayed = Double.toString(saleDetail.getTotalVAT());
        totalCost = Double.toString(saleDetail.getRunningTotal());
        amountPaid = Double.toString(payment.getAmountPayed());
        change = Double.toString(payment.getAmountPayed() - saleDetail.getRunningTotal());

        storeName = store.getName();
        storeAddress = store.getStoreAddress().toString();
        CustomerServiceEmailAddress = store.getStoreContactInfo().getEmail();
        CustomerServicePhoneNumber  = store.getStoreContactInfo().getPhoneNumber();
    }

}

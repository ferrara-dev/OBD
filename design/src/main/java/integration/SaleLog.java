package integration;

import integration.productdb.ProductDB;
import model.Calendar;
import model.salemodel.SaleDetail;

import java.util.ArrayList;
import java.util.HashMap;

public class SaleLog {
    HashMap<String, ArrayList<SaleDetail>> saleDetailHashMap;

    public SaleLog() {
        saleDetailHashMap = new HashMap<>();
    }

    public void logSale(SaleDetail saleDetail) {
        String date = Calendar.getCurrentDate();
        if (saleDetailHashMap.containsKey(date)) {
            saleDetailHashMap.get(date).add(saleDetail);
        }
        else {
            saleDetailHashMap.keySet().add(date);
            saleDetailHashMap.put(date, new ArrayList<SaleDetail>());
        }

        ProductDB.updateInventory(saleDetail.getProcessedGoods());
        AccountingSystem.updateAccounting(saleDetail);
    }

}

package integration;

import model.salemodel.SaleDetail;

import java.util.ArrayList;
import java.util.HashMap;

public class SaleLog {
    HashMap<String, ArrayList<SaleDetail>> saleDetailHashMap;

    public SaleLog() {
        saleDetailHashMap = new HashMap<>();
    }

    public void logSale(SaleDetail saleDetail) {

    }

}

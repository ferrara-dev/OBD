package integration;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListSelectionModel;
import model.Calendar;
import model.salemodel.SaleDetail;

import java.util.ArrayList;
import java.util.HashMap;

import util.NotFoundException;

public class SaleLog {

    HashMap<String, ArrayList<SaleDetail>> saleDetailHashMap;

    public SaleLog()  {
        saleDetailHashMap = new HashMap<>();
        List<String> datesOfTheYear =  Calendar.getDatesBetween(Calendar.getCurrentDate());
        for(String date: datesOfTheYear)
            saleDetailHashMap.put(date,new ArrayList<SaleDetail>());
    }

    public void logSale(SaleDetail saleDetail) {
        saleDetailHashMap.get(Calendar.getCurrentDate()).add(saleDetail);
        saleDetail.updateSaleDetail();
    }

    public SaleDetail getLoggedSale(String dayOfSale, String saleId){
        ArrayList<SaleDetail> listOfSales = saleDetailHashMap.get(dayOfSale);
        if(listOfSales.isEmpty())
            throw new NotFoundException("No sales stored that day");
        boolean found = false;

        SaleDetail searchedSale = null;
        for (SaleDetail saleDetail: listOfSales){
            if(saleDetail.getSaleId().getValue() == saleId){
                searchedSale = saleDetail;
                break;
            }
        }

        if(Objects.isNull(searchedSale)){
            throw new NotFoundException("Specified saleId does not match any sale conducted on " + dayOfSale);
        }

        return searchedSale;
    }

    private void tagSale(){

    }


}

package integration;

import model.Calendar;
import model.salemodel.SaleDetail;
import util.NotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SaleLog implements Serializable {

    HashMap<String, ArrayList<SaleDetail>> saleDetailHashMap;
    private static final long serialVersionUID = 21313123123L;

    public SaleLog()  {
        saleDetailHashMap = new HashMap<>();
        List<String> datesOfTheYear =  Calendar.getDatesBetween(Calendar.getCurrentDate());
        for(String date: datesOfTheYear)
            saleDetailHashMap.put(date,new ArrayList<SaleDetail>());
    }

    public void logSale(SaleDetail saleDetail) {
        saleDetailHashMap.get(Calendar.getCurrentDate()).add(saleDetail);
    }

    public SaleDetail getLoggedSale(String dayOfSale, String saleId){
        ArrayList<SaleDetail> listOfSales = saleDetailHashMap.get(dayOfSale);
        if(listOfSales.isEmpty())
            throw new NotFoundException("No sales stored that day");

        SaleDetail searchedSale = null;
        for (SaleDetail saleDetail: listOfSales){
            if(saleDetail.getSaleId().getValue().equals(saleId)){
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

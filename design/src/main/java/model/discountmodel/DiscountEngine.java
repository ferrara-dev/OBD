package model.discountmodel;
import integration.DiscountRegestry;
import integration.discountdb.DiscountDTO;
import model.Calendar;
import model.salemodel.SaleDetail;
import startup.LayerCreator;

import java.util.List;


public class DiscountEngine{
    public double totalPriceReduction;
    List<DiscountDTO> discountDTOS;
    public DiscountEngine(SaleDetail saleDetail){
        discountDTOS = getOffers();
        totalPriceReduction = DiscountLogic.ApplyDiscountLogic(saleDetail,discountDTOS);
    }

    public List<DiscountDTO> getOffers(){
        return DiscountRegestry.getAvailableDiscounts(Calendar.getDayOfTheWeek().name());
    }




    /**
     *  return new DailyOffer(Discount.DISCOUNT_REGESTRY.getDiscountItemId(Calendar.getDayOfTheWeek().name()),
     *                 Discount.DISCOUNT_REGESTRY.getDiscountType(Calendar.getDayOfTheWeek().name()));
     */
}

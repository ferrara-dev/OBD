package integration;

import integration.discountdb.DiscountDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscountRegestry {
  // public static List<DiscountOffer> discountList;
   Map<String,List<DiscountDTO>> discountMap;
   private static List<DiscountDTO> discounts;

   /*
    public DiscountRegestry(List<DiscountOffer> discountList){
        this.discountList = discountList;
    }
    */

    public DiscountRegestry(List<DiscountDTO> discounts){
        this.discounts = discounts;
        discountMap = Map.of(
                "MONDAY",getDiscountOffers("MONDAY"),
                "TUESDAY",getDiscountOffers("TUESDAY"),
                "WEDNESDAY", getDiscountOffers("WEDNESDAY"),
                "THURSDAY",getDiscountOffers("THURSDAY"),
                "FRIDAY", getDiscountOffers("FRIDAY"),
                "SATURDAY",getDiscountOffers("SATURDAY"),
                "SUNDAY",getDiscountOffers("SUNDAY")
        );
        System.out.println(discountMap.toString());
    }

    public Map<String, List<DiscountDTO>> getDiscountMap() {
        return discountMap;
    }

    private List<DiscountDTO> getDiscountOffers(String dayOfTheWeek){
        List <DiscountDTO> tempList = new ArrayList<>();
        for(DiscountDTO offer: discounts){
            if(offer.getAvailable().equals(dayOfTheWeek)){
                tempList.add(offer);

            }


        }
        return tempList;
    }

    public List<DiscountDTO> getAvailableDiscounts(String dayOfTheWeek){
       return discountMap.get(dayOfTheWeek);
    }
    /*

    public int getDiscountItemId(String dayOfTheWeek){
        return getDiscountOffer(dayOfTheWeek).rule.discountItem.itemId;
    }

    public String getDiscountType(String dayOfTheWeek){
        return getDiscountOffer(dayOfTheWeek).rule.type;
    }
    public DiscountOffer getDiscountOffer(String dayOfTheWeek){
        for(DiscountOffer offer: discountList){
            if(offer.rule.description.equals(dayOfTheWeek)){
                return offer;
            }
        }
        return null;
    }
*/

}

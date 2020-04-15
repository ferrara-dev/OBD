package integration;

import integration.discountdb.DiscountDTO;
import org.h2.mvstore.MVMap;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class DiscountRegestry {
  // public static List<DiscountOffer> discountList;
   static Map<String,List<DiscountDTO>> discountMap;
   private static List<DiscountDTO> discounts;

   /*
    public DiscountRegestry(List<DiscountOffer> discountList){
        this.discountList = discountList;
    }
    */

    public DiscountRegestry(List<DiscountDTO> discounts){
        this.discounts = discounts;

        discountMap = Stream.of(
                new AbstractMap.SimpleEntry<>("MONDAY",getDiscountOffers("MONDAY")),
                new AbstractMap.SimpleEntry<>("TUESDAY",getDiscountOffers("TUESDAY")),
                new AbstractMap.SimpleEntry<>("WEDNESDAY", getDiscountOffers("WEDNESDAY")),
                new AbstractMap.SimpleEntry<>("THURSDAY",getDiscountOffers("THURSDAY")),
                new AbstractMap.SimpleEntry<>("FRIDAY", getDiscountOffers("FRIDAY")),
                new AbstractMap.SimpleEntry<>("SATURDAY",getDiscountOffers("SATURDAY")),
                new AbstractMap.SimpleEntry<>("SUNDAY",getDiscountOffers("SUNDAY"))
        ).collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

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

    public static List<DiscountDTO> getAvailableDiscounts(String dayOfTheWeek){
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

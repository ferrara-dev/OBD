package integration.discountdb;

import model.discountmodel.Discount;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class DiscountDB{
    DiscountDBLoader loader;
    private Map<String, List<String>> discounts;

    public DiscountDB() throws Exception {
        loader = new DiscountDBLoader();
        load();
    }

    private void load() throws Exception {
        discounts = loader.discounts;
    }

    public List<DiscountDTO> getDiscountList() {
        List<DiscountDTO> searchResult = new ArrayList<>();
        discounts.keySet().forEach(discount -> {
            DiscountDTO discountDTO = new DiscountDTO(discounts.get(discount).get(0),
                    discounts.get(discount).get(1),
            discounts.get(discount).get(2),
                    discounts.get(discount).get(3),
                    discounts.get(discount).get(4),
                   discounts.get(discount).get(5));
            searchResult.add(discountDTO);
        });
        return searchResult;
    }



/**
 public List<DiscountOffer> createDiscountList() {
 List<DiscountOffer> searchResult = new ArrayList<>();
 discounts.keySet().forEach(offer->{

 DiscountOffer offer1 = new DiscountOffer(Integer.parseInt(offer));
 offer1.rule.type = discounts.get(offer).get(1);
 System.out.println(offer1.rule.type);
 offer1.rule.description = discounts.get(offer).get(2);
 System.out.println(offer1.rule.description);

 searchResult.add(offer1);
 });
 return searchResult;
 }

 public void printResult(List<String> result) {
 System.out.println("Search result: " + result);
 result.forEach(key->{
 System.out.println("======================================================");
 System.out.println("Product: " + key);
 System.out.println("======================================================");
 IntStream.range(0, 5).forEach(index-> {
 String nutritionKey = headers.get(index);
 //System.out.println( products.get(key).size());
 if(index<discounts.get(key).size() && discounts.containsKey(key)) {
 System.out.println(nutritionKey + ": " + discounts.get(key).get(index));
 }
 });
 });
 }
 */
}

package integration.discountdb;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class DiscountDB implements IProductDB{

    private List<String> rows;
    private List<String> headers;
    static Map<String,List<String>> discounts;



    public void load() throws Exception {
        rows = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(FILENAME).toURI()), Charset.forName("UTF-8"));
        headers = extractHeaders(rows);
        discounts = extractDiscount(rows);
    }

    private List<String> extractHeaders(final List<String> rows) {
        final List<String> headers = new ArrayList<>();
        List<String> arr = Arrays.asList(rows.get(HEADERS_POSITION).split(SEMICOLON));
        IntStream.range(HEADER_VALUES_START_POSITION,  arr.size()).forEach(index-> headers.add(arr.get(index)));
        return headers;
    }

    public List<DiscountDTO> createDiscountList() {
        List<DiscountDTO> searchResult = new ArrayList<>();
        discounts.keySet().forEach(discount->{
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

    private Map<String,List<String>> extractDiscount(final List<String> rows) {
        final Map<String,List<String>> products = new HashMap<>();
        IntStream.range(PRODUCTS_START_POSITION, rows.size()).forEach(index-> {
            String[] row = rows.get(index).split(SEMICOLON);

            String key = row[1];
            //System.out.println("key: " + key);
            String[] values = Arrays.copyOfRange(row, 0, 8);
            List<String> listOfValues = Arrays.asList(values);
            List<String> modifiedList = new ArrayList<>();
            listOfValues.forEach(value->{
                modifiedList.add(value);
            });
            //System.out.println("values: " + listOfValues);
            products.put(key,  modifiedList);
        });
        return products;
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

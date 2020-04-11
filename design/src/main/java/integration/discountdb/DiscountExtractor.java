package integration.discountdb;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class DiscountExtractor implements IProductDB {

    protected DiscountExtractor(){

    }

    public void load() throws Exception {

    }

    protected Map<String,List<String>> extractDiscount(final List<String> rows) {
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
}

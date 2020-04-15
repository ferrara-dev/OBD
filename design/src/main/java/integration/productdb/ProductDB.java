package integration.productdb;

import model.itemmodel.ProcessedGoods;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static util.CsvUtil.getStrings;
public class ProductDB {

    public static final int HEADERS_POSITION = 0;
    public static final int HEADER_VALUES_START_POSITION = 0;
    public static final int PRODUCTS_START_POSITION = 1;
    private static final String SEMICOLON = ";";


    private final String FILENAME = "dbtest.csv";
    private List<String> rows;
    private List<String> headers;
    static Map<String,List<String>> products;



    public void load() throws Exception {
        rows = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(FILENAME).toURI()), StandardCharsets.UTF_8);
        headers = extractHeaders(rows);
        products = extractProducts(rows);
    }

    private List<String> extractHeaders(final List<String> rows) {
        return getStrings(rows, HEADERS_POSITION, SEMICOLON, HEADER_VALUES_START_POSITION);
    }

    private Map<String,List<String>> extractProducts(final List<String> rows) {
        final Map<String,List<String>> products = new HashMap<>();
        IntStream.range(PRODUCTS_START_POSITION, rows.size()).forEach(index-> {
            String[] row = rows.get(index).split(SEMICOLON);

            String key = row[0];
            //System.out.println("key: " + key);
            String[] values = Arrays.copyOfRange(row, 0, 7);
            List<String> listOfValues = Arrays.asList(values);
            List<String> modifiedList = new ArrayList<>();
            listOfValues.forEach(value->{
                modifiedList.add(value.replace(",", "."));
            });
            //System.out.println("values: " + listOfValues);
            products.put(key,  modifiedList);
        });
        return products;
    }

    public List<Item> createProductList() {
        List<Item> searchResult = new ArrayList<>();
        products.keySet().forEach(product->{
            double price = Double.parseDouble(products.get(product).get(3));
            String category = products.get(product).get(4);
            int itemId = Integer.parseInt(products.get(product).get(5));
            int stockStatus = Integer.parseInt(products.get(product).get(6));
            Item product1 = new Item(product,price,category,itemId,stockStatus);

            searchResult.add(product1);
        });
        return searchResult;
    }

    public void updateDiscountedItems(){

    }

    public static void updateInventory(ProcessedGoods processedGoods){

    }
}


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
}

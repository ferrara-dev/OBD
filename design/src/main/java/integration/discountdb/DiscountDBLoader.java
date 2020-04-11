package integration.discountdb;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DiscountDBLoader implements IProductDB {

    protected List<String> rows;
    protected List<String> headers;
    protected Map<String, List<String>> discounts;
    DiscountExtractor extractor;

    protected DiscountDBLoader() throws Exception {
        load();
        extractor = new DiscountExtractor();
        discounts = extractor.extractDiscount(rows);
    }

    public void load() throws Exception {
        rows = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(FILENAME).toURI()), Charset.forName("UTF-8"));
        headers = extractHeaders(rows);
    }

    private List<String> extractHeaders(final List<String> rows) {
        final List<String> headers = new ArrayList<>();
        List<String> arr = Arrays.asList(rows.get(HEADERS_POSITION).split(SEMICOLON));
        IntStream.range(HEADER_VALUES_START_POSITION,  arr.size()).forEach(index-> headers.add(arr.get(index)));
        return headers;
    }

}

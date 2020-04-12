package integration.discountdb;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.Map;
import static util.CsvUtil.getStrings;

public class DiscountDBLoader implements IDiscountDB {

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
        return getStrings(rows, HEADERS_POSITION, SEMICOLON, HEADER_VALUES_START_POSITION);
    }


}

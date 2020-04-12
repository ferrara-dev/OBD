package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CsvUtil {
    public static List<String> getStrings(List<String> rows, int headersPosition, String semicolon, int headerValuesStartPosition) {
        final List<String> headers = new ArrayList<>();
        List<String> arr = Arrays.asList(rows.get(headersPosition).split(semicolon));
        IntStream.range(headerValuesStartPosition,  arr.size()).forEach(index-> headers.add(arr.get(index)));
        return headers;
    }
}

package model.itemmodel;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Tax {
    private static final Map<String, Double> taxRates =
            Stream.of( new AbstractMap.SimpleEntry<>("Misc",0.25D), new AbstractMap.SimpleEntry<>("Viand",0.125D), new AbstractMap.SimpleEntry<>("Literature",0.06D)).collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

     static double getTax(String key){
        return taxRates.get(key);
    }

}
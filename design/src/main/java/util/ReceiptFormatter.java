package util;

import model.salemodel.Receipt;
import org.h2.util.StringUtils;
import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ReceiptFormatter {
    private final int SECTION_LENGTH = 10;
    private final String[] HEADERS = new String[]{"Item", "Price", "Quantity", "VAT"};
    private String returnValue;
    private Receipt receipt;
    public ReceiptFormatter(Receipt receipt){
        this.receipt = receipt;
    }

    public String formatReceipt() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int j = 0; j < receipt.itemNames.length; j++) {
            stringBuilder.append("- " + receipt.itemNames[j]);
            stringBuilder.append(" " + receipt.itemPrices[j]);
            stringBuilder.append("kr");
            stringBuilder.append(" " + receipt.itemQuantites[j]);
            stringBuilder.append("st");
            stringBuilder.append("\n");


        }
        System.out.println(stringBuilder.toString());
        stringBuilder.append("Total summa : " + receipt.totalCost + " kr\n");
        stringBuilder.append("Varav moms  : " + receipt.totalTaxPayed + " kr\n");
        stringBuilder.append("Betalt : " + receipt.amountPaid + " kr\n");
        stringBuilder.append("Tillbaks : " + receipt.change + " kr\n");
        stringBuilder.append("------------------------------------------------------------------\n");
        stringBuilder.append("Tidpunkt för försäljning : " + receipt.timeAndDateOfSale + "\n");

        return stringBuilder.toString();
    }

    private  int stringLength(String s){
        return s.length();
    }

    private int longestWord(String [] strings){
        int longestWord = 0;
        if(strings.length == 0)
            return longestWord;

        for (int i = 1; i < strings.length; i++) {
            longestWord = strings[i].length();
            if (longestWord < strings[i - 1].length())
                longestWord = strings[i - 1].length();
        }
        return longestWord;
    }

    private String getSpaces(int n) {
        StringBuilder spaces = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    private  void setReturnValue(String s) {
        returnValue = s;
    }

    private static String tab(String str, int lengthOfLine) {
        int numberOfTabs = lengthOfLine - str.length();
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < numberOfTabs; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

}

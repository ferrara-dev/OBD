package util;

import model.physicalobjects.Receipt;

public class ReceiptFormatter {
    private final int SECTION_LENGTH = 10;
    private final String[] HEADERS = new String[]{"Item", "Price", "Quantity", "VAT"};
    private String returnValue;
    private Receipt receipt;

    public ReceiptFormatter(Receipt receipt){
        this.receipt = receipt;
    }

    private String goodsToString() {
        return
             "Purchased Items :\n" + receipt.getSale().getSaleDetail().asText() + '\n';
    }

    private String saleInfoToString(){
        String amountPaid = String.valueOf(receipt.getSale().getTotalCost() + receipt.getSale().getCashBack());
        return     "totalCost : " + receipt.getSale().getTotalCost() + '\n' +
                    "Amount payed : " + amountPaid + "\n" +
                "totalVAT : " + receipt.getSale().getTotalVAT() + " kr\n" +
                "cashBack : " + receipt.getSale().getCashBack() + " kr\n" +
                "timeAndDateOfSale : " + receipt.getSale().getSaleDetail().getTimeAndDateOfSale() + '\n' +
                "Sale id " + receipt.getSale().getSaleDetail().getSaleId();
    }

    public String formatReceipt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(goodsToString() + "\n");
        stringBuilder.append("------------------------------------------------------------------\n");
        stringBuilder.append(saleInfoToString() + "\n");
        stringBuilder.append("------------------------------------------------------------------\n");
        stringBuilder.append(receipt.getStore().toString());
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

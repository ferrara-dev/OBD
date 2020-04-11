package integration;
import model.salemodel.Receipt;
import util.ReceiptFormatter;

public class Printer {

    public static String print(Receipt paper){
        ReceiptFormatter formatter = new ReceiptFormatter(paper);
        String printedReceipt = formatter.formatReceipt();
        return printedReceipt;
    }
}

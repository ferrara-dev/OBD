package util;

public class FormatException extends NumberFormatException {
    public final String PAYMENT_INPUT_WRONG_FORMAT = "WRONG FORMAT IN PAYMENT SECTION \n" +
            "please enter a numerical value";
    public final String ITEM_INPUT_WRONG_FORMAT = "\"WRONG FORMAT IN ITEM ID SECTION \n" +
            " please enter an integer";

    public FormatException(){

    }
}

package util;



public class NotFoundException extends RuntimeException {
    public final String ITEM_NOT_FOUND_MESSAGE = "ITEM NOT FOUND \n please try again";
    public final String CUSTOMER_NOT_FOUND_MESSAGE =  "CUSTOMER ID NOT FOUND NOT FOUND IN DATABASE";

    public NotFoundException(){
        super();
    }

    public NotFoundException(String s){

        super(s);
    }

}

package model.salemodel;

import java.util.UUID;

/**
 * Class representing a unique id used to identify each sale
 */
public class SaleId {
    private String id;

    public SaleId(){
        id =  UUID.randomUUID().toString();
    }

    public String getValue() {
        return id;
    }
}

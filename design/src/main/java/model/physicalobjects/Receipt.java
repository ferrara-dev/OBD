package model.salemodel;
import java.text.DecimalFormat;
import model.Store;
import util.Address;
import util.ContactInformation;


public class Receipt {
    private final Store store = new Store(
            new Address("STORE STREET","A CITY","A COUNTRY", " 19149"),
            new ContactInformation("store@storemail.com","077 777 77 77"));
    Sale sale;


    public Receipt(Sale sale)
    {
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }

    public Store getStore() {
        return store;
    }
}

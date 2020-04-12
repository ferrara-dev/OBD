package model;

import model.salemodel.Register;
import util.Address;
import util.ContactInformation;

/**
 * class used to initialize all physical objects at program startup
 */
public class PhysicalObjectCreator {
    private final Register cashRegister;
    private final Store store;
    private final Address address;
    private final ContactInformation contactInformation;

    public PhysicalObjectCreator(){
        address = new Address("Store street 123", "Store City","Sweden","191 49");
        contactInformation = new ContactInformation("spof@kth.se", "070 123 4567","Store street 123 - 191 49 - Sweden");
        store = new Store(address,contactInformation);
        cashRegister = new Register(store);
    }

    public Register getCashRegister() {
        return cashRegister;
    }

    public Store getStore() {
        return store;
    }
}

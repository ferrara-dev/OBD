package model;

import util.Address;
import util.ContactInformation;

/**
 * class representing the physical store where the sale is conducted
 */
public class Store {
    private final String name = "A store";
    private Address storeAddress;
    private ContactInformation storeContactInfo;

    public Store(Address address, ContactInformation contactInformation){
        this.storeAddress = address;
        this.storeContactInfo = contactInformation;
    }

    public String getName() {
        return name;
    }

    public Address getStoreAddress() {
        return storeAddress;
    }

    public ContactInformation getStoreContactInfo() {
        return storeContactInfo;
    }

}
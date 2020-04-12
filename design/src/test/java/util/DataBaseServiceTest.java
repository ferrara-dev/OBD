package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseServiceTest {

    @Test
    void findCustomer() {
        // Test if the service class can find customer in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_CUSTOMER_BY_ID, "940412-1395"));
    }


    @Test
    void findProduct() {
        // Test if the service class can find product in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_PRODUCT_BY_ID, "1"));
    }

    @Test
    void addProduct() {
        // Test if the service class can find product in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_PRODUCT_BY_ID, "1"));
    }
}
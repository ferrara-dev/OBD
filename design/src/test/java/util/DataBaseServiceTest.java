package util;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DataBaseServiceTest {

    @Test
    public void findCustomer() {
        // Test if the service class can find customer in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_CUSTOMER_BY_ID, "940412-1395"));
    }


    @Test
    public void findProduct() {
        // Test if the service class can find product in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_PRODUCT_BY_ID, "1"));
    }

    @Test
    public void addProduct() {
        // Test if the service class can find product in database
        assertTrue(DataBaseService.find(DataBaseService.SQL_FIND_PRODUCT_BY_ID, "1"));
    }
}
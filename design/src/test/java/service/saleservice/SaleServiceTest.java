package service.saleservice;

import model.item.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaleServiceTest {
    SaleService saleService;
    Product [] products = new Product[3];
    @Before
    public void setUp() throws Exception {
        //saleService = new SaleService();
        products [0] = saleService.itemService.getItem(1);
        products [1] = saleService.itemService.getItem(2);
        products [2] = saleService.itemService.getItem(1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void startSale() {

    }

    @Test
    public void registerItem() {

        saleService.registerItem(products[0],1);
       // boolean itemFound = saleService.findSaleItem(1);
    //    assertTrue(itemFound);

     //   SaleItem foundItem = saleService.getSale().getSaleDetail().getGoods().get(1);

    //    assertNotNull(foundItem);

        saleService.registerItem(products[0],1);
    }

    @Test
    public void findSaleItem() {
    }

    @Test
    public void updateSaleItemQuantity() {
    }
}
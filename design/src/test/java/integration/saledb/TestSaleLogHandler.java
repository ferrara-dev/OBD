package integration.saledb;

import integration.DataBaseHandler;
import model.sale.Sale;
import org.junit.After;
import org.junit.Before;
import startup.LayerCreator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestSaleLogHandler {
    LayerCreator creator;
    DataBaseHandler <Sale,Object> handler;

    @Before
    public void setUp() throws Exception {
        creator = new LayerCreator();
        handler = new SaleLogHandler();
    }

    @After
    public void tearDown() throws Exception {

    }
/**
    @Test
    public void testLogSale(){
        Sale firstSale = createSale("1");
        String firstSaleId = firstSale.getSaleDetail().getSaleId().getValue();
        handler.register(firstSale.getSaleDetail().getSaleId().getValue(),firstSale);

        Sale firstLoggedSale = handler.collect(firstSaleId);
        assertNotNull(firstLoggedSale);
        assertEquals(firstLoggedSale.getSaleDetail().getGoods().get(1).getClass(), firstSale.getSaleDetail().getGoods().get(1).getClass());
        assertTrue(compare(firstSale,firstLoggedSale));

      //  assertEquals(firstLoggedSale,firstSale);

        Sale secondSale = createSale("2");
        String secondSaleId = secondSale.getSaleDetail().getSaleId().getValue();
        handler.register(secondSaleId,secondSale);

        Sale secondLoggedSale = handler.collect(secondSaleId);
        assertNotNull(secondLoggedSale);
        assertEquals(secondLoggedSale.getSaleDetail().getGoods().get(1).getClass(), secondSale.getSaleDetail().getGoods().get(1).getClass());
        assertTrue(compare(secondSale,secondLoggedSale));

        assertFalse(compare(firstLoggedSale,secondLoggedSale));
        assertFalse(compare(firstSale,secondSale));
    }
    public Sale createSale(String i){
        DataBaseHandler<ItemDTO,Integer> inventoryHandler = new InventoryHandler();
        ItemDTO itemDTO= inventoryHandler.collect(i);
        Product product = new Product();
        product.createItemModel(itemDTO);
        Sale sale = new Sale();
        sale.createDefault();
      //  sale.getSaleDetail().getGoods().putIfAbsent(1, product);
        return sale;
    }
*/
    public boolean compare(Sale first, Sale second){
        if(first.getSaleDetail().getSaleId().getValue().equals(second.getSaleDetail().getSaleId().getValue()))
            return true;

        return false;
    }
}
package service;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import model.salemodel.Sale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.saleservice.SaleService;
import startup.LayerCreator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class testSaleService {
    LayerCreator layerCreator;
    SaleController saleController;
    ItemController itemController;
    DiscountController discountController;

    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();
        saleController = layerCreator.getSaleController();
        discountController = layerCreator.getDiscountController();
        itemController = layerCreator.getItemController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSaleService() throws Exception {
        saleController.startSale();
        SaleService saleService = saleController.getSaleService();
        Sale sale = saleService.getSale();

        assertNotNull(saleService);
        assertNotNull(sale);

        for(int i = 1; i < 7; i++){
            itemController.registerItem(i,5);
        }

        double cost = saleService.getSale().getTotalCost();
        double runningTotal = saleService.getSale().getRunningTotal();
        assertEquals(cost,runningTotal);


    }

    @Test
    public void testDiscountService() {

    }
}

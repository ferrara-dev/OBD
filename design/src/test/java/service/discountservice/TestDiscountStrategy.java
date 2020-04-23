package service.discountservice;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import model.sale.Sale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.discountservice.discountstrategy.DiscountStrategy;
import service.saleservice.SaleService;
import startup.LayerCreator;

public class TestDiscountStrategy {
    DiscountStrategy discountStrategy;
    DiscountController discountController;
    SaleController saleController;
    ItemController itemController;
    SaleService saleService;
    Sale sale;

    @Before
    public void setUp() throws Exception {

        LayerCreator layerCreator = new LayerCreator();
       // saleController = layerCreator.getSaleController();
      //  discountController = layerCreator.getDiscountController();
      //  itemController = layerCreator.getItemController();
       // saleController.startSale();
       // saleService = saleController.getSaleService();
      //  sale = saleService.getSale();

        for (int i = 1; i < 7; i++) {
            itemController.registerItem(i, 5);
        }

    }

    @After
    public void tearDown() throws Exception {
        saleController = null;
        discountController = null;
        itemController = null;
        SaleService saleService = saleController.getSaleService();
        sale = saleService.getSale();
    }

    @Test
    public void testBulkDiscountStrategy() throws Exception {
        DiscountService discountService = discountController.getDiscountService();
        discountService.findOffers("940412-1395");

    }
}

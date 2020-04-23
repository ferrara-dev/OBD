package service.discountservice;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import model.sale.Sale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.saleservice.SaleService;
import startup.LayerCreator;

import static junit.framework.TestCase.assertNotNull;

public class TestDiscountService {
    LayerCreator layerCreator;
    SaleController saleController;
    ItemController itemController;
    DiscountController discountController;
    SaleService saleService;
    Sale sale;

    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();
      //  saleController = layerCreator.getSaleController();
        //discountController = layerCreator.getDiscountController();
      //  itemController = layerCreator.getItemController();
        saleController.startSale();
        SaleService saleService = saleController.getSaleService();
        sale = saleService.getSale();

        for (int i = 1; i < 7; i++) {
            itemController.registerItem(i, 5);
        }

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDiscountService() throws Exception {


    }


}

package testbasicflow;
import controller.ItemController;
import controller.SaleController;
import model.itemmodel.ProcessedGoods;
import model.salemodel.SaleDetail;
import model.salemodel.SaleModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class TestBasicFlow {

    LayerCreator layerCreator;

    @Before
    public void setUp() throws Exception {
         layerCreator = new LayerCreator();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testSaleStartUp() {
        SaleController saleController = layerCreator.getSaleController();
        assertEquals("Sale Started",saleController.startSale());

        testSaleIsActive(saleController.getSalemodel());
    }

    private void testSaleIsActive(SaleModel saleModel) {
        assertTrue(saleModel.getSaleDetail().isActive());
    }

    @Test
    public void testBasicFlow() {
        SaleController saleController = layerCreator.getSaleController();
        ItemController itemController = layerCreator.getItemController();
        SaleModel saleModel = saleController.getSalemodel();
        // Start the sale
        assertEquals("Sale Started",saleController.startSale());

        SaleDetail saleDetail = saleModel.getSaleDetail();
        ProcessedGoods processedGoods = saleDetail.getProcessedGoods();

        // check if processedGoods are empty
        assertTrue(processedGoods.isEmpty());
        // Register an item
        itemController.registerItem(1,2);
        // Check if processedGoods is still empty
        assertFalse(processedGoods.isEmpty());
        // end the sale
        saleController.endSale();
        // check if sale is completed
        assertTrue(saleDetail.isCompleted());
        // check so that total price of the purchased item equals to the running total
       assertEquals(processedGoods.getItem(1).totalPrice ,saleDetail.getRunningTotal());
       // pay the purchase
       saleController.enterPayment(saleDetail.getRunningTotal() + 100);
       // check so that change is 100
        assertEquals(100D ,saleDetail.getCashBack());

    }

    @Test
    public void endSale() {

    }

    @Test
    public void enterPayment() {

    }

    @Test
    public void applyDiscountToSale() {

    }
}

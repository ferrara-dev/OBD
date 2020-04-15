package integration;

import controller.ItemController;
import controller.SaleController;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import model.Calendar;
import model.itemmodel.ProcessedGoods;
import model.salemodel.SaleDetail;
import model.salemodel.SaleModel;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;

public class SaleLogTest {
    LayerCreator layerCreator;

    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void logSale() {
            SaleController saleController = layerCreator.getSaleController();
            ItemController itemController = layerCreator.getItemController();
            saleController.startSale();
            SaleModel saleModel = saleController.getSalemodel();
            // Start the sale
            assertEquals("Sale Started",saleController.startSale());

            SaleDetail saleDetail = saleModel.getSaleDetail();

            System.out.println(saleDetail.getSaleId());
            // check if processedGoods are empty

            // Register an item
            itemController.registerItem(1,2);
            // Check if processedGoods is still empty

            // end the sale
            saleController.endSale();
            // check if sale is completed

            // check so that total price of the purchased item equals to the running total
            assertEquals(saleDetail.getProcessedGoods().getItem(1).totalPrice ,saleDetail.getRunningTotal());
            // pay the purchase
            saleController.enterPayment(saleDetail.getRunningTotal() + 100);
            // check so that change is 100
            assertEquals(100D ,saleDetail.getCashBack());

            // The sale should now be stored in the saleLog
            SaleLog saleLog =  layerCreator.getRegestryCreator().getSaleLog();


            String id = saleDetail.getSaleId().getValue();
            assertEquals(saleDetail.getSaleId(), saleLog.getLoggedSale(Calendar.getCurrentDate(), id).getSaleId());
        }

    /**
     * Test to make sure that saleId is not reset to 0 when creating a new instance of saleDetail
     * @throws Exception
     */
    @Test
    public void startSale() throws Exception {
        SaleModel testSaleModel = new SaleModel();
        testSaleModel.startSale();
        assertTrue(testSaleModel.getSaleDetail().isActive());

        String firstId = testSaleModel.getSaleDetail().getSaleId().getValue();
        testSaleModel.endSale();

        assertEquals(firstId, layerCreator.getRegestryCreator().getSaleLog().getLoggedSale(Calendar.getCurrentDate(), firstId));

        testSaleModel.startSale();
        String secondId = testSaleModel.getSaleDetail().getSaleId().getValue();
       // assertEquals(2, testSaleModel.getSaleDetail().getSaleId());

    }

}
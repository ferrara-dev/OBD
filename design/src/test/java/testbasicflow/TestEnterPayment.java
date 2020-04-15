package testbasicflow;

import controller.ItemController;
import controller.SaleController;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import model.salemodel.SaleModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;
import util.NotFoundException;

public class TestEnterPayment {

    LayerCreator layerCreator;
    SaleController saleController;
    ItemController itemController;
    SaleModel saleModel;

    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();
        saleController = layerCreator.getSaleController();
        itemController = layerCreator.getItemController();
        saleModel = saleController.getSalemodel();
        registerItems();
        saleModel.endSale();
    }

    public void registerItems() {
        itemController.registerItem(1, 1);
        itemController.registerItem(2, 1);
        itemController.registerItem(3, 3);
        itemController.registerItem(4, 2);
    }

    @After
    public void tearDown() {
        layerCreator = null;
        saleController = null;
        itemController = null;
        saleModel = null;
    }

    @Test
    public void testEndSale() {
        assertTrue(saleModel.getSaleDetail().isCompleted());
    }

    @Test
    public void testPayment() {
        testEndSale();
        double totalCost = 0;
        for (ItemModel model : saleModel.getSaleDetail().getProcessedGoods().getGoods()) {
            totalCost += model.totalPrice;
        }
        /*
         * assert that <Code> totalCost <\code> is equal to
         * accumulated price of the products bought
         * also assert that <Code> cashBack <\code> is 0 and <Code> runningTotal <\code>
         * equals to <Code> totalCost <\code> before a payment has been made.
         */
        assertEquals(totalCost, saleModel.getSaleDetail().getTotalCost());
        assertEquals(saleModel.getSaleDetail().getRunningTotal(), saleModel.getSaleDetail().getTotalCost());
        assertEquals(0D,saleModel.getSaleDetail().getCashBack());

        saleController.enterPayment(totalCost + 100);
        /*
         * assert that <Code> totalCost <\code> remains the same after payment.
         * also assert that <Code> cashBack <\code> equals to the difference between
         * <code> amountPayed <\code> and the total cost <Code> runningTotal <\code>
         * equals to 0
         */
        assertEquals(totalCost,saleModel.getSaleDetail().getTotalCost());
        assertEquals(100D, saleModel.getSaleDetail().getCashBack());
        assertEquals(0D, saleModel.getSaleDetail().getRunningTotal());
    }
}

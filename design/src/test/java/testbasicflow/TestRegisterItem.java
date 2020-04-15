package testbasicflow;

import controller.ItemController;
import controller.SaleController;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import model.itemmodel.ProcessedGoods;
import model.salemodel.SaleModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;
import util.NotFoundException;

public class TestRegisterItem {

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
    }

    @After
    public void tearDown() {
        layerCreator = null;
        saleController = null;
        itemController = null;
        saleModel = null;
    }

    @Test
    public void testRegisterItem(){
        itemController.registerItem(1, 1);
        assertFalse(saleModel.getSaleDetail().getProcessedGoods().isEmpty());
    }

    @Test(expected = NotFoundException.class)
    public void testItemNotFound(){
        itemController.registerItem(99, 2);
    }

    @Test
    public void testRegisterMultipleItemsOfSameType(){
        itemController.registerItem(1, 3);
        assertEquals(3,saleModel.getSaleDetail().getProcessedGoods().getItemQuantity(1));
    }

    @Test
    public void testRegisterItemAddToQuantity(){
        ProcessedGoods processedGoods = saleModel.getSaleDetail().getProcessedGoods();
        itemController.registerItem(1, 3);
        assertEquals(3,processedGoods.getItemQuantity(1));
        itemController.registerItem(2, 3);
        assertEquals(3, processedGoods.getItemQuantity(2));
        itemController.registerItem(1, 5);
        assertEquals(8, processedGoods.getItemQuantity(1));
        itemController.registerItem(2, 1);
        assertEquals(4, processedGoods.getItemQuantity(2));

        assertTrue(processedGoods.contains(1));
        assertTrue(processedGoods.contains(2));
    }

    @Test
    public void testEndSale(){
        saleModel.endSale();
        assertTrue(saleModel.getSaleDetail().isCompleted());
    }

    @Test
    public void testPayment(){
        assertEquals(0D,saleModel.getSaleDetail().getTotalCost());
    }

}

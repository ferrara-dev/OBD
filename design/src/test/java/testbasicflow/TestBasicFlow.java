package testbasicflow;

import controller.ItemController;
import controller.SaleController;
import static junit.framework.TestCase.assertNotSame;
import model.Calendar;
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
import startup.Main;
import util.NotFoundException;


public class TestBasicFlow {

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

    }


    @Test
    public void testSaleStartUp() {
        SaleController saleController = layerCreator.getSaleController();
        assertEquals("Sale Started", saleController.startSale());
        assertTrue(saleModel.getSaleDetail().isActive());
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
    public void testRegisterMultipleItem(){
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
        assertEquals(0,saleModel.getSaleDetail().getTotalCost());
    }
    public void registerItem(ProcessedGoods processedGoods, int itemId, int quantity){
        itemController.registerItem(itemId, quantity);

        // Check if processedGoods is still empty
        assertFalse(processedGoods.isEmpty());
    }

    @Test
    public void testBasicFlow() {
        // Start the sale

        assertEquals("Sale Started",  saleController.startSale());

        SaleDetail saleDetail = saleModel.getSaleDetail();
        ProcessedGoods processedGoods = saleDetail.getProcessedGoods();
        //test if the sale is set active
        assertTrue(saleDetail.isActive());

        // check if processedGoods are empty
        assertTrue (processedGoods.isEmpty());

        // Register an item
        registerItem(processedGoods, 1, 2);

        // end the sale
        saleController.endSale();

        String saleId = saleModel.getSaleDetail().getSaleId().getValue();

        // check if sale is completed
        assertTrue(saleDetail.isCompleted());

        // check so that total price of the purchased item equals to the running total
        assertEquals(processedGoods.getItem(1).totalPrice, saleDetail.getRunningTotal());

        // pay the purchase
        saleController.enterPayment(saleDetail.getRunningTotal() + 100);

        // check so that change is 100
        assertEquals(100D, saleDetail.getCashBack());

        //confirm that the sale has been logged
        layerCreator.getRegestryCreator().getSaleLog().getLoggedSale(Calendar.getCurrentDate(), saleId);

        // start a new sale and confirm that the two identifications not equal
        saleController.startSale();
        saleModel = saleController.getSalemodel();
        saleDetail = saleModel.getSaleDetail();
        String otherSaleId = saleDetail.getSaleId().getValue();

        assertNotSame(saleId, otherSaleId);
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

package testbasicflow;
import controller.ItemController;
import controller.SaleController;
import model.itemmodel.ProcessedGoods;
import model.salemodel.SaleDetail;
import model.salemodel.SaleModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import startup.LayerCreator;
import static org.junit.jupiter.api.Assertions.*;

public class testbasicflow {

    LayerCreator layerCreator;

    @BeforeEach
    void setUp() throws Exception {
         layerCreator = new LayerCreator();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testSaleStartUp() throws Exception {
        SaleController saleController = layerCreator.getSaleController();
        assertEquals("Sale Started",saleController.startSale());

        testSaleIsActive(saleController.getSalemodel());
    }

    @Test
    void testSaleIsActive(SaleModel saleModel) {
        assertTrue(saleModel.getSaleDetail().isActive());
    }

    @Test
    void testBasicFlow() {
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
        assertEquals(100 ,saleDetail.getCashBack());

    }

    @Test
    void endSale() {

    }

    @Test
    void enterPayment() {

    }

    @Test
    void applyDiscountToSale() {

    }
}

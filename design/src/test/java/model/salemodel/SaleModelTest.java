package model.salemodel;

import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;


import static junit.framework.TestCase.*;



class SaleModelTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;

    @Before
    void setUp() {
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }



/*


    @Test
    void registerItemWithValidItemId() throws Exception {
        SaleModel testSaleModel = new SaleModel();
        // check if the right
        assertEquals(0,testSaleModel.getSaleDetail().getProcessedGoods().getItemQuantity(1));
        // Start a new sale
        testSaleModel.startSale();
        // check if the item already exists
        assertFalse(testSaleModel.getSaleDetail().getProcessedGoods().contains(1));


        // check if the item was added to processedGoods
        assertTrue(testSaleModel.getSaleDetail().getProcessedGoods().contains(1));
        // check if the right quantity was added
        assertEquals(2,testSaleModel.getSaleDetail().getProcessedGoods().getItem(1).quantity);
    }


 */

    @Test
    void endSale() throws Exception {
        SaleModel testSaleModel = new SaleModel();
        //Start a new sale
        testSaleModel.startSale();
        //Check is sale is active
        assertTrue(testSaleModel.getSaleDetail().isActive());
        //End the sale
        testSaleModel.endSale();
        //Check if the sale has been set as completed
        assertTrue(testSaleModel.getSaleDetail().isCompleted());
    }
}
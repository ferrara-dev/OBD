package model.salemodel;

import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import startup.LayerCreator;
import util.NotFoundException;

import static junit.framework.TestCase.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaleModelTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;
    @BeforeEach
    void setUp() {
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    void registerItemInvalidItemId() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () ->   testSaleModel.registerItem(99,99));
        // assertions on the thrown exception
        assertEquals("Item not found", thrown.getMessage());

    }

    @Test
    void registerItemWithValidItemId() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
        // check if the right
        assertEquals(0,testSaleModel.getSaleDetail().getProcessedGoods().getItemQuantity(1));
        // Start a new sale
        testSaleModel.startSale();
        // check if the item already exists
        assertFalse(testSaleModel.getSaleDetail().getProcessedGoods().contains(1));
        testSaleModel.registerItem(1,2);

        // check if the item was added to processedGoods
        assertTrue(testSaleModel.getSaleDetail().getProcessedGoods().contains(1));
        // check if the right quantity was added
        assertEquals(2,testSaleModel.getSaleDetail().getProcessedGoods().getItem(1).quantity);
    }


    @Test
    void startSale() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
        testSaleModel.startSale();
        assertTrue(testSaleModel.getSaleDetail().isActive());
    }


    @Test
    void endSale() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
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
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
    void registerItem() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () ->   testSaleModel.registerItem(99,99));
        // assertions on the thrown exception
        assertEquals("Item not found", thrown.getMessage());
    }

    @Test
    void startSale() throws Exception {
        SaleModel testSaleModel = new SaleModel(new LayerCreator().getRegestryCreator());
        testSaleModel.startSale();
        assertTrue(testSaleModel.saleDetail.isActive());
    }


    @Test
    void endSale() {
    }
}
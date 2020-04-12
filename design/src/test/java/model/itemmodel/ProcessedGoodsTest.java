package model.itemmodel;

import controller.SaleController;
import integration.productdb.ItemDTO;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import startup.LayerCreator;

public class ProcessedGoodsTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;
    private SaleController saleController;
    @Before
    public void setUp() throws Exception {
        saleController = new SaleController(new LayerCreator());
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }

    @After
    public void tearDown() {
        goods = null;
    }
    @Test
    public void startSale(){

    }
    @Test
    public void getGoods() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void getItem() {
    }

    @Test
    public void getItemQuantity() {
    }

    @Test
    public void processedGoodsAsText() {
    }
}
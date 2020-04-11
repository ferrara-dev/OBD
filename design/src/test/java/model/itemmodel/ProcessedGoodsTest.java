package model.itemmodel;

import controller.SaleController;
import integration.productdb.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import startup.LayerCreator;

import static org.junit.jupiter.api.Assertions.*;

class ProcessedGoodsTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;
    private SaleController saleController;
    @BeforeEach
    void setUp() throws Exception {
        saleController = new SaleController(new LayerCreator());
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }

    @AfterEach
    void tearDown() {
        goods = null;
    }
    @Test
    void startSale(){

    }
    @Test
    void getGoods() {
    }

    @Test
    void contains() {
    }

    @Test
    void getItem() {
    }

    @Test
    void getItemQuantity() {
    }

    @Test
    void processedGoodsAsText() {
    }
}
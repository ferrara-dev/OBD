package model.salemodel;

import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleDetailTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;

    @BeforeEach
    void setUp() {
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void setTimeAndDateOfSale() {
    }

    @Test
    void getTotalVAT() {
    }

    @Test
    void getTimeAndDateOfSale() {
    }

    @Test
    void setActive() {
    }

    @Test
    void setCompleted() {
    }

    @Test
    void isActive() {
    }

    @Test
    void isCompleted() {
    }

    @Test
    void getRunningTotal() {
    }

    @Test
    void getCashBack() {
    }

    @Test
    void setSaleLineItem() {
    }

    @Test
    void getProcessedGoods() {
    }

    @Test
    void updateSaleDetail() {
    }

    @Test
    void updateRunningTotal() {
    }
}
package model.salemodel;


import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaleDetailTest {
    private ProcessedGoods goods;
    private ItemModel item;
    private ItemDTO itemDTO;

    @Before
    public void setUp() {
        goods = new ProcessedGoods();
        itemDTO = new ItemDTO("item", 20, "viand", 99, 500);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void setTimeAndDateOfSale() {
    }

    @Test
    public void getTotalVAT() {
    }

    @Test
    public void getTimeAndDateOfSale() {
    }

    @Test
    public void setActive() {
    }

    @Test
    public void setCompleted() {
    }

    @Test
    public void isActive() {
    }

    @Test
    public void isCompleted() {
    }

    @Test
    public void getRunningTotal() {
    }

    @Test
    public void getCashBack() {
    }

    @Test
    public void setSaleLineItem() {
    }

    @Test
    public void getProcessedGoods() {
    }

    @Test
    public void updateSaleDetail() {
    }

    @Test
    public void updateRunningTotal() {
    }
}
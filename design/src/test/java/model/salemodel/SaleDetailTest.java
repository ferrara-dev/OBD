package model.salemodel;


import controller.ItemController;
import controller.SaleController;
import integration.ItemDetail;
import integration.productdb.ItemDTO;
import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;

public class SaleDetailTest {
    LayerCreator layerCreator;
    SaleController saleController;
    ItemController itemController;
    SaleModel saleModel;
    SaleDetail saleDetail;
    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();
        saleController = layerCreator.getSaleController();
        itemController = layerCreator.getItemController();
        saleModel = saleController.getSalemodel();
        saleModel.startSale();
        saleDetail = saleModel.getSaleDetail();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void setTimeAndDateOfSale() {
        saleDetail.completeSale();
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
        saleDetail.setSaleLineItem(new ItemModel(new ItemDetail("hello", 100, "No", 50, 999),100));
        saleDetail.updateSaleDetail();
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
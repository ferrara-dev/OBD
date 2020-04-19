package controller;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;

import static junit.framework.TestCase.assertEquals;


public class SaleControllerTest {
    LayerCreator layerCreator;

    @Before
    public void setUp() throws Exception {
        layerCreator = new LayerCreator();

    }

    @After
    public void tearDown() {

    }

    @Test
    public void startSale() throws Exception {
        assertEquals("Sale Started", layerCreator.getSaleController().startSale());
    }

    @Test
    public void registerItem() throws Exception {
         layerCreator.getItemController().registerItem(1,2);
    }

    @Test
    public void endSale() {
        assertEquals("Sale Started", layerCreator.getSaleController().startSale());
        layerCreator.getItemController().registerItem(1,2);
        layerCreator.getSaleController().endSale();
    }

    @Test
    public void enterPayment() {
        assertEquals("Sale Started", layerCreator.getSaleController().startSale());
        layerCreator.getItemController().registerItem(1,2);
        layerCreator.getSaleController().endSale();
        layerCreator.getSaleController().getPaymentService().setPayment(200);
        layerCreator.getSaleController().getPaymentService().processPayment(layerCreator.getPhysicalObjectCreator().getCashRegister());
    }

    @Test
    public void applyDiscountToSale() {

    }
}
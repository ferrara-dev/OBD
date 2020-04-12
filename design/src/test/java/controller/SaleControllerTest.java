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
        LayerCreator layerCreator = new LayerCreator();

    }

    @After
    public void tearDown() {

    }

    @Test
    public void startSale() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
        assertEquals("Sale Started", layerCreator.getSaleController().startSale());

    }

    @Test
    public void endSale() {

    }

    @Test
    public void enterPayment() {

    }

    @Test
    public void applyDiscountToSale() {

    }
}
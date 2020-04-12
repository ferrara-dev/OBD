package controller;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import startup.LayerCreator;

import static org.junit.jupiter.api.Assertions.*;

class SaleControllerTest {
    LayerCreator layerCreator;

    @BeforeEach
    void setUp() throws Exception {
        LayerCreator layerCreator = new LayerCreator();

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void startSale() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
        assertEquals("Sale Started", layerCreator.getSaleController().startSale());

    }

    @Test
    void endSale() {

    }

    @Test
    void enterPayment() {

    }

    @Test
    void applyDiscountToSale() {

    }
}
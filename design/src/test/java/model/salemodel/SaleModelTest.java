package model.salemodel;

import integration.RegestryCreator;
import org.junit.jupiter.api.Test;
import startup.LayerCreator;
import util.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SaleModelTest {

    @Test
    void registerItem() throws Exception {
        SaleModel testSaleModel = new SaleModel(new RegestryCreator());
        // assert statements
        assertEquals(new NotFoundException(), testSaleModel.registerItem(99,1), "item was not found");
    }

    @Test
    void startSale() {
    }

    @Test
    void endSale() {
    }
}
package integration.discountdb;

import integration.DataBaseHandler;
import integration.datatransferobject.DiscountDTO;
import model.discountmodel.Discount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;

import java.util.List;

import static org.junit.Assert.*;

public class TestDiscountRegistryHandlerTest {
    LayerCreator creator;
    DataBaseHandler<List, Discount> handler;
    @Before
    public void setUp() throws Exception {
        creator = new LayerCreator();
        handler = new DiscountRegistryHandler();
    }

    @After
    public void tearDown() throws Exception {
        creator = null;
        handler = null;
    }

    @Test
    public void testCollectDiscountDTOs(){
        List<DiscountDTO> discountDTOS = handler.collect("bla bla");
        assertNotNull(discountDTOS);
        assertNotEquals(0, discountDTOS.size());
    }

}
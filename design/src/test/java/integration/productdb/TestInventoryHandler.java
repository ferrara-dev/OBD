package integration.productdb;

import integration.DataBaseHandler;
import integration.datatransferobject.ItemDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import startup.LayerCreator;
import util.NotFoundException;

import static org.junit.Assert.*;

public class TestInventoryHandler {
    DataBaseHandler<ItemDTO,Integer> handler;
    LayerCreator creator;

    @Before
    public void setUp() throws Exception {
        creator = new LayerCreator();
        handler = new InventoryHandler();
    }

    @After
    public void tearDown() throws Exception {
        creator = null;
        handler = null;
    }

    @Test
    public void testFindItem(){
        boolean itemFound = handler.find("1");
        assertTrue(itemFound);
    }

    @Test
    public void testCollectItemDTO(){
        ItemDTO collectedItem = handler.collect("1");
        assertNotNull(collectedItem);
        ItemDTO anotherCollectedItem = handler.collect("5");
        assertNotNull(anotherCollectedItem);
        assertNotEquals(anotherCollectedItem, collectedItem);
    }

    @Test (expected = NotFoundException.class)
    public void testCollectUndefindedItem(){
        ItemDTO collectedItem = handler.collect("99");
    }

    @Test
    public void updateInventory(){
        ItemDTO collectedItem = handler.collect("1");
        int thisStockStatus = collectedItem.getStockStatus();
        handler.register("1",thisStockStatus-1);
        ItemDTO anotherCollectedItem = handler.collect("1");
        int thatStockStatus = anotherCollectedItem.getStockStatus();
        assertNotEquals(thisStockStatus,thatStockStatus);
    }
}
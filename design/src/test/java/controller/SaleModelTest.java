package controller;

import org.junit.Test;
import startup.LayerCreator;
import util.NotFoundException;

import static junit.framework.TestCase.assertNotNull;

public class SaleModelTest {




    @Test(expected = NotFoundException.class)
    public void test() throws Exception {
        LayerCreator creator = new LayerCreator();
        ItemController itemController = creator.getItemController();
        String str =  itemController.registerItem(10,10);
        assertNotNull(str);
    }
}

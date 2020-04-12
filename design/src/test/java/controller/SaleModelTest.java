package controller;

import integration.RegestryCreator;
import model.salemodel.SaleModel;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class SaleModelTest {




    @Test
    public void test() throws Exception {
        RegestryCreator creator = new RegestryCreator();
        SaleModel model = new SaleModel(creator);
        String str = model.registerItem(10, 10);
        assertNotNull(str);
    }
}

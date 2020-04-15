package integration;

import model.itemmodel.ItemModel;
import model.salemodel.SaleDetail;
import model.salemodel.SaleModel;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DBServiceTest {

    @Test
    public void testLogSale() {
      /*  SaleDetail detail = new SaleDetail();
        detail.createDefault();
        detail.setActive(true);
        ItemDetail itemDetail = new ItemDetail("Mjölk 3,0%",12.58,"Viand", 111, 1000);
        int quantity = 2;
        ItemModel item = new ItemModel(itemDetail, quantity);
        detail.setSaleLineItem(item);*/
    //    DBService.logSale(detail.getSaleId().getValue(),detail );

    //    SaleDetail sd = DBService.getSale(detail.getSaleId().getValue());
   //     assertNotNull(sd);
   //     assertEquals(detail.getSaleId().getValue(),sd.getSaleId().getValue());

        ItemDetail itemDetail1 = DBService.getProduct(1);
        System.out.println(itemDetail1);
        int res = DBService.updateProduct(1,200);
        itemDetail1 = DBService.getProduct(1);
        System.out.println(itemDetail1);
    }
}

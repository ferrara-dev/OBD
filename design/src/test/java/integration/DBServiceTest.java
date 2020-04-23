package integration;

import integration.datatransferobject.ItemDTO;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import startup.LayerCreator;

public class DBServiceTest {
/*
    @Test
    public void testLogSale() {
        SaleDetail detail = new SaleDetail();
        detail.createDefault();
        detail.setActive(true);
        ItemDTO itemDTO = new ItemDTO("Mjölk 3,0%",12.58,"Viand", 111, 1000);
        int quantity = 2;
        ItemModel item = new ItemModel(itemDTO);
        item.setQuantity(2);
        detail.setSaleLineItem(item);
        DBService.logSale(detail.getSaleId().getValue(),detail);

        SaleDetail sd = DBService.getSale(detail.getSaleId().getValue());
        assertNotNull(sd);
        assertEquals(detail.getSaleId().getValue(),sd.getSaleId().getValue());
        assertEquals(detail.getProcessedGoods().getGoods(),sd.getProcessedGoods().getGoods());
    }
*/
    @Test
    public void testLogSale() throws Exception {

    }

    @Test
    public void testInventory() {
        Boolean found = DBService.find("1");
        ItemDTO itemDTO = DBService.getProduct("2");
        DBService.updateProduct(2, 499);
        ItemDTO dto = DBService.getProduct("2");
        assertEquals(499, dto.getStockStatus());
        assertEquals(2, itemDTO.getItemId());
    }
/*
    @Test
    public void registerItem() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
        ItemController itemController = layerCreator.getItemController();
        itemController.registerItem(2, 5);

        assertEquals(1,layerCreator.getSaleController().getSaleService().getSale().getSaleDetail().getGoods().size());
        assertEquals(5,layerCreator.getSaleController().getSaleService().getSale().getSaleDetail().getGoods().get(2).getQuantity());
    }
*/
    @Test
    public void discountDataBase() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
      //  SaleController saleController = layerCreator.getSaleController();
    //    DiscountController discountController = layerCreator.getDiscountController();
   //     saleController.startSale();
     //  DiscountService discountService = new DiscountService(saleController.getSaleService());
  //&/     discountService.findOffers("940412-1395");
      // assertNotNull(discountService.getDiscountDTOS().get(0));
    }
}

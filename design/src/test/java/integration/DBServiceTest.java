package integration;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import integration.productdb.ItemDTO;
import model.salemodel.Sale;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import service.discountservice.DiscountService;
import service.saleservice.SaleService;
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
        LayerCreator layerCreator = new LayerCreator();
        SaleController saleController = layerCreator.getSaleController();
        saleController.startSale();
        SaleService saleService = saleController.getSaleService();
        Boolean found = DBService.find("7");
        ItemDTO itemDTO = DBService.getProduct("7");
        saleService.registerItem(itemDTO,1);
        String saleId = saleService.getSale().getSaleDetail().getSaleId().getValue();
        saleController.endSale();
        saleController.enterPayment(50);

        Sale sd = DBService.getSale(saleId);
        assertNotNull(sd);
        assertEquals(saleId,sd.getSaleDetail().getSaleId().getValue());
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

    @Test
    public void registerItem() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
        ItemController itemController = layerCreator.getItemController();
        itemController.registerItem(2, 5);

        assertEquals(1,layerCreator.getSaleController().getSaleService().getSale().getSaleDetail().getGoods().size());
        assertEquals(5,layerCreator.getSaleController().getSaleService().getSale().getSaleDetail().getGoods().get(2).getQuantity());
    }

    @Test
    public void discountDataBase() throws Exception {
        LayerCreator layerCreator = new LayerCreator();
        SaleController saleController = layerCreator.getSaleController();
        DiscountController discountController = layerCreator.getDiscountController();
        saleController.startSale();
       DiscountService discountService = new DiscountService(saleController.getSaleService());
       discountService.findOffers("940412-1395");
       assertNotNull(discountService.getDiscountDTOS().get(0));
    }
}

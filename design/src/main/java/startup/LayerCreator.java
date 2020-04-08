package startup;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import integration.RegestryCreator;


public class LayerCreator {
    private RegestryCreator regestryCreator;
    private SaleController saleController;
    private DiscountController discountController;
    private ItemController itemController;

    public LayerCreator() throws Exception {
        regestryCreator = new RegestryCreator();
        saleController = new SaleController(regestryCreator);
        discountController = new DiscountController(this);
        itemController = new ItemController(this);

    }
    public RegestryCreator getRegestryCreator(){
        return regestryCreator;
    }
    public SaleController getSaleController() {
        return saleController;
    }

    public ItemController getItemController() {
        return itemController;
    }

    public DiscountController getDiscountController() {
        return discountController;
    }
}

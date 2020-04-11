package startup;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import integration.RegestryCreator;
import model.PhysicalObjectCreator;


public class LayerCreator {
    private RegestryCreator regestryCreator;
    private SaleController saleController;
    private DiscountController discountController;
    private ItemController itemController;
    private PhysicalObjectCreator physicalObjectCreator;

    public LayerCreator() throws Exception {
        regestryCreator = new RegestryCreator();
        saleController = new SaleController(this);
        discountController = new DiscountController(this);
        itemController = new ItemController(this);
        physicalObjectCreator = new PhysicalObjectCreator();

    }

    public PhysicalObjectCreator getPhysicalObjectCreator() {
        return physicalObjectCreator;
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

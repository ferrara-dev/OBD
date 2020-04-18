package startup;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import model.PhysicalObjectCreator;


public class LayerCreator {

    private SaleController saleController;
    private DiscountController discountController;
    private ItemController itemController;
    private PhysicalObjectCreator physicalObjectCreator;

    public LayerCreator() throws Exception {

        saleController = new SaleController(this);
        discountController = new DiscountController(this);
        itemController = new ItemController(this);
        physicalObjectCreator = new PhysicalObjectCreator();

    }

    public PhysicalObjectCreator getPhysicalObjectCreator() {
        return physicalObjectCreator;
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

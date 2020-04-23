package startup;

import model.PhysicalObjectCreator;
import model.customer.CustomerService;
import service.discountservice.DiscountService;
import service.inventoryservice.ItemService;
import service.saleservice.SaleService;

public class ServiceFactory {
    private SaleService saleService;
    private ItemService itemService;
    private DiscountService discountService;
    private PhysicalObjectCreator physicalObjectCreator;
    private CustomerService customerService;

    public ServiceFactory(LayerCreator layerCreator){
        physicalObjectCreator = layerCreator.getPhysicalObjectCreator();
        saleService = new SaleService(this);
        itemService = new ItemService();
        discountService = new DiscountService(this);
    }

    public PhysicalObjectCreator getPhysicalObjectCreator() {
        return physicalObjectCreator;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public ItemService getItemService() {
        return itemService;
    }
}

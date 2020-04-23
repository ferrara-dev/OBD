package startup;

import controller.ControllerFactory;
import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import model.PhysicalObjectCreator;


public class LayerCreator {

    private PhysicalObjectCreator physicalObjectCreator;
    private ControllerFactory controllerFactory;
    private ServiceFactory serviceFactory;

    public LayerCreator() throws Exception {
        serviceFactory = new ServiceFactory(this);
        controllerFactory = new ControllerFactory(this);
        physicalObjectCreator = new PhysicalObjectCreator();

    }

    public ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public PhysicalObjectCreator getPhysicalObjectCreator() {
        return physicalObjectCreator;
    }
}

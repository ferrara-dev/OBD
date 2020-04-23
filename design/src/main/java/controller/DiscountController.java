package controller;

import service.discountservice.DiscountService;
import startup.LayerCreator;
import startup.ServiceFactory;

import java.util.Objects;


public class DiscountController extends AbstractController{

    public DiscountController(ServiceFactory serviceFactory){
        super(serviceFactory);
    }

    public DiscountService getDiscountService() {
        return super.discountService;
    }

    /**
     * Signal a discount request by the customer
     * Calls instance of <code> DiscountService </code> to process customer identification
     *
     * @param customerId
     * @return the discount model is returned back the the view to be interpreted for output
     */
    public void signalDiscountRequest(String customerId){
        if(Objects.isNull(super.discountService))
            throw new IllegalStateException();

        super.discountService.findOffers(customerId);
        super.discountService.applyDiscount();
    }

}

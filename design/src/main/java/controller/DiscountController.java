package controller;

import model.discountmodel.Discount;
import service.discountservice.DiscountService;
import startup.LayerCreator;

import java.util.Objects;


public class DiscountController {
    private LayerCreator creator;
    private DiscountService discountService;


    public DiscountController(LayerCreator LayerCreator){
        this.creator = LayerCreator;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    /**
     * Signal a discount request by the customer
     * Calls instance of <code> DiscountService </code> to process customer identification
     *
     * @param customerId
     * @return the discount model is returned back the the view to be interpreted for output
     */
    public Discount signalDiscountRequest(String customerId){
        if(Objects.isNull(discountService))
            discountService = new DiscountService(creator.getSaleController().getSaleService());

        discountService.findOffers(customerId);
        Discount discount = discountService.createDiscountModel();
        creator.getSaleController().applyDiscountToSale(discount);
       return discount;
    }

}

package service.discountservice;

import integration.DataBaseHandler;
import integration.discountdb.DiscountRegistryHandler;
import integration.datatransferobject.DiscountDTO;

import java.util.ArrayList;
import java.util.List;

import model.discountmodel.Discount;
import service.discountservice.discountpolicy.BulkDiscountPolicy;
import service.discountservice.discountpolicy.BuyNItemsGetMFreePolicy;
import service.discountservice.discountpolicy.DiscountPolicy;
import service.discountservice.discountpolicy.PriceDiscountPolicy;
import service.saleservice.SaleService;


public class DiscountService {
    private final DataBaseHandler<List,Discount> dataBaseHandler = new DiscountRegistryHandler();
    private List<DiscountDTO> discountDTOS;
    List<DiscountPolicy> discountPolicies;
    SaleService saleService;


    public DiscountService(SaleService saleService) {
        this.saleService = saleService;
    }

    public List<DiscountPolicy> getDiscountPolicies() {
        return discountPolicies;
    }

    /**
     * Finds all offers that are available to a customer the current day.
     * Calls instance of <code> DiscountRegistryHandler </code> to collect available
     * discounts, given that the parameter <code> customerId </code>
     * is a valid customer identification.
     * @param customerId
     */
    public void findOffers(String customerId) {
        // TODO:  fixa så att ett <code> Customer <\code> objekt returneras här
        dataBaseHandler.find(customerId);

        // TODO: fixa så <code> dataBaseHandler.collect(customerId) <\code>
        //       tar ett <code> Customer <\code> objekt som argument
        discountDTOS = dataBaseHandler.collect(customerId);
        generateDiscountPolicies();
    }


    public List<DiscountDTO> getDiscountDTOS() {
        return discountDTOS;
    }

    /**
     * Creates a discount model that can be applied to the current sale
     * @return
     */
    public Discount createDiscountModel() {
        Discount discount = new Discount();
        double totalPriceReduction = 0;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy instanceof BulkDiscountPolicy)
                discount.getItemDiscounts().add(discountPolicy.calculateDiscount(saleService.getSale()));
            else if (discountPolicy instanceof BuyNItemsGetMFreePolicy)
                discount.getItemDiscounts().add(discountPolicy.calculateDiscount(saleService.getSale()));
            else if (discountPolicy instanceof PriceDiscountPolicy)
                discount.getItemDiscounts().add(discountPolicy.calculateDiscount(saleService.getSale()));

            totalPriceReduction += discountPolicy.getTotalPriceReduction();
            discount.setTotalPriceReduction(totalPriceReduction);
        }
        return discount;
    }

    private void generateDiscountPolicies() {
        discountPolicies = new ArrayList<>();
        DiscountStrategy discountStrategy;
        for (DiscountDTO discountDTO : discountDTOS) {
            discountStrategy = new DiscountStrategy(discountDTO);
            discountPolicies.add(discountStrategy.generateDiscountPolicy());
        }
    }

}

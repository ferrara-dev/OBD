package service.discountservice;

import integration.DataBaseHandler;
import integration.discountdb.DiscountRegistryHandler;
import integration.datatransferobject.DiscountDTO;

import java.util.ArrayList;
import java.util.List;

import model.discount.Discount;
import model.discount.discountpolicy.DiscountPolicy;
import service.discountservice.discountstrategy.DiscountStrategy;
import service.saleservice.SaleService;
import startup.ServiceFactory;


public class DiscountService {
    private final DiscountStrategyFactory discountStrategyFactory;
    private List<DiscountStrategy> discountStrategies;
    private final DataBaseHandler<List, Discount> dataBaseHandler;
    private List<DiscountDTO> discountDTOS;
    List<DiscountPolicy> discountPolicies;
    SaleService saleService;


    public DiscountService(ServiceFactory serviceFactory) {
        this.discountStrategyFactory = new DiscountStrategyFactory();
        discountStrategies = new ArrayList<>();
        this.saleService = getSaleService();
        dataBaseHandler = new DiscountRegistryHandler();
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public List<DiscountPolicy> getDiscountPolicies() {
        return discountPolicies;
    }

    /**
     * Finds all offers that are available to a customer the current day.
     * Calls instance of <code> DiscountRegistryHandler </code> to collect available
     * discounts, given that the parameter <code> customerId </code>
     * is a valid customer identification.
     *
     * Calls <code> discountStrategyFactory </code> to create appropriate
     * strategies to apply on the sale.
     * @param customerId
     */
    public void findOffers(String customerId) {
        // TODO:  fixa så att ett <code> Customer <\code> objekt returneras här
        dataBaseHandler.find(customerId);

        // TODO: fixa så <code> dataBaseHandler.collect(customerId) <\code>
        //       tar ett <code> Customer <\code> objekt som argument
        discountDTOS = dataBaseHandler.collect(customerId);
        discountStrategies = discountStrategyFactory.getDiscountStrategies(this);
    }


    public List<DiscountDTO> getDiscountDTOS() {
        return discountDTOS;
    }

    /**
     * Applies appropriate discount strategies  to the current sale
     *
     * @return
     */
    public void applyDiscount() {
        if (discountStrategies != null && discountStrategies.size() != 0) {
            for (DiscountStrategy discountStrategy : discountStrategies) {
                discountStrategy.applyDiscount();
            }
        }
    }

}

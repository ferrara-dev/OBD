package service.discountservice.discountstrategy;

import integration.datatransferobject.DiscountDTO;
import model.discount.discountpolicy.PriceDiscountPolicy;
import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.sale.Sale;
import service.saleservice.SaleService;
import util.IllegalDiscountCombinationException;

import java.util.ArrayList;

public class PriceDiscountStrategy implements DiscountStrategy {
    private Sale sale;
    private ArrayList<PriceDiscountPolicy> priceDiscountPolicies;

    public PriceDiscountStrategy(SaleService saleService) {
        sale = saleService.getSale();
        priceDiscountPolicies = new ArrayList<>();
    }

    @Override
    public boolean applyStrategy(DiscountDTO discountDTO) {
                double minimumSpent = Double.parseDouble(discountDTO.getRequirement());
                double priceReduction = Double.parseDouble(discountDTO.getReduction());
                PriceDiscountPolicy priceDiscountPolicy = new PriceDiscountPolicy(minimumSpent, priceReduction);
                priceDiscountPolicies.add(priceDiscountPolicy);

        return priceDiscountWasAdded();
    }

    @Override
    public ArrayList getDiscountPolicies() {
        return this.priceDiscountPolicies;
    }

    @Override
    public void calculateDiscount() {
        for (PriceDiscountPolicy discountPolicy : priceDiscountPolicies) {
            double minimumSpent = discountPolicy.getMinimumSpent();
            double priceReduction = discountPolicy.getReduction();
            double totalPriceReduction = 0;
            if (sale.getSaleDetail().isCompleted() && sale.getSaleDetail().isActive()) {
                double totalPrice = sale.getCost().getTotalCost();
                if (minimumSpent <= totalPrice) {
                    totalPriceReduction = totalPrice * priceReduction;
                    discountPolicy.setTotalPriceReduction(totalPriceReduction);

                }
            } else if (sale.getSaleDetail().isActive() && !sale.getSaleDetail().isCompleted()) {
                double totalPrice = sale.getCost().getTotalCost();
                if (minimumSpent <= totalPrice)
                    totalPriceReduction = totalPrice * priceReduction;
                discountPolicy.setTotalPriceReduction(totalPriceReduction);
            }
        }

    }

    @Override
    public void applyDiscount() {
        for (PriceDiscountPolicy discountPolicy : priceDiscountPolicies)
            try {
                sale.getCost().setPriceDiscount(new PriceDiscount(discountPolicy));
            } catch (IllegalDiscountCombinationException exp) {
                continue;
            }
    }

    private boolean priceDiscountWasAdded() {
        return !priceDiscountPolicies.isEmpty();
    }
}

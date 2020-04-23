package service.discountservice;

import integration.datatransferobject.DiscountDTO;
import service.discountservice.discountstrategy.BulkDiscountStrategy;
import service.discountservice.discountstrategy.DiscountStrategy;
import service.discountservice.discountstrategy.PriceDiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class DiscountStrategyFactory {

    public DiscountStrategyFactory() {

    }

    public List<DiscountStrategy> getDiscountStrategies(DiscountService discountService) {
        List<DiscountStrategy> discountStrategies = new ArrayList<>();
        DiscountStrategy strategy;
        for (DiscountDTO dto : discountService.getDiscountDTOS()) {
            if (dto.getType() == DiscountStrategy.BULK_DISCOUNT) {
                strategy = new BulkDiscountStrategy(discountService.getSaleService());
                strategy.applyStrategy(dto);
                strategy.calculateDiscount();
                discountStrategies.add(strategy);
            } else if (dto.getType() == DiscountStrategy.PRICE_DISCOUNT) {
                strategy = new PriceDiscountStrategy(discountService.getSaleService());
                strategy.applyStrategy(dto);
                strategy.applyDiscount();
                discountStrategies.add(strategy);
            }
        }

        return discountStrategies;
    }
}


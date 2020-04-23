package service.discountservice.discountstrategy;

import integration.datatransferobject.DiscountDTO;
import model.discount.discountpolicy.BulkDiscountPolicy;
import model.discount.discounttypes.itemdiscount.BulkDiscount;
import model.sale.Sale;
import service.saleservice.SaleService;
import util.IllegalDiscountCombinationException;
import util.NotFoundException;

import java.util.ArrayList;
import java.util.Objects;

public class BulkDiscountStrategy implements DiscountStrategy {
    private Sale sale;
    private ArrayList<BulkDiscountPolicy> bulkDiscountPolicies;

    public BulkDiscountStrategy(SaleService saleService) {
        if (Objects.isNull(saleService))
            throw new IllegalArgumentException();

        this.sale = saleService.getSale();
        this.bulkDiscountPolicies = new ArrayList<>();
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean applyStrategy(DiscountDTO discountDTO) {
        int itemIdCounter = 0;
        String[] discountItemId = discountDTO.getItemId().split(":");
        int[] itemId = new int[discountItemId.length];
                for (int i = 0; i < itemId.length; i++)
                    itemId[i] = Integer.parseInt(discountItemId[i]);

                while (itemIdCounter < itemId.length) {
                    int minimumAmountOfItems = Integer.parseInt(discountDTO.getRequirement());
                    int limit = Integer.parseInt(discountDTO.getLimit());
                    double priceReduction = Double.parseDouble(discountDTO.getReduction());
                    BulkDiscountPolicy bulkDiscountPolicy = new BulkDiscountPolicy(itemId[itemIdCounter++], minimumAmountOfItems, limit, priceReduction);
                    bulkDiscountPolicies.add(bulkDiscountPolicy);
                }

        return bulkDiscountWasAdded();
    }

    @Override
    public ArrayList<BulkDiscountPolicy> getDiscountPolicies() {
        return this.bulkDiscountPolicies;
    }

    @Override
    public void calculateDiscount() {
        for (BulkDiscountPolicy bulkDiscountPolicy : bulkDiscountPolicies) {
            int itemId = bulkDiscountPolicy.getItemId();
            int minimumAmountOfItems = bulkDiscountPolicy.getMinimumAmountOfItems();
            double reduction = bulkDiscountPolicy.getReduction();
            double totalPriceReduction = 0;
            int itemQuantity;
            double itemPrice;

            try {
                itemQuantity = sale.getCart().getItem(itemId).getQuantity();
            } catch (NotFoundException ex) {
                continue;
            }

            if (itemQuantity >= minimumAmountOfItems) {
                itemPrice = sale.getCart().getItem(itemId).getProduct().getTotalPrice();
                totalPriceReduction += itemPrice * reduction;
                bulkDiscountPolicy.setTotalPriceReduction(totalPriceReduction);
            }
        }


    }

    @Override
    public void applyDiscount() {
        for (BulkDiscountPolicy bulkDiscountPolicy : bulkDiscountPolicies) {
            int itemId = bulkDiscountPolicy.getItemId();
            try {
                sale.getCart().getItem(itemId).setItemDiscount(new BulkDiscount(bulkDiscountPolicy));
            } catch (IllegalDiscountCombinationException exp) {
                continue;
            }
        }
    }

    private boolean bulkDiscountWasAdded(){
        return !bulkDiscountPolicies.isEmpty();
    }

}

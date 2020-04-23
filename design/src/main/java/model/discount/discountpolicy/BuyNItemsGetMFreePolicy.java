package model.discount.discountpolicy;

import model.item.Product;
import model.sale.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * 12. Derive BuyNItemsGetOneFree from DiscountPolicy, as described in Exercise 10.
 * The class should have a constructor that has a single parameter n. In
 * addition, the class should define the method computeDiscount so that every
 * nth item is free.
 */

public class BuyNItemsGetMFreePolicy extends DiscountPolicy {
    private final String discountClass = "Item discount";
    private final String discountType = "Buy N Items Get M Free";
    private final int requiredAmountOfItems;
    private final int[] itemId;
    private final int limit;
    private final double reduction;
    private double totalPriceReduction;
    private List<Product> discountedItems;

    public BuyNItemsGetMFreePolicy(int requiredAmountOfItems, int[] itemId, int limit, double priceReduction) {
        this.requiredAmountOfItems = requiredAmountOfItems;
        this.itemId = itemId;
        this.limit = limit;
        this.reduction = priceReduction;
        discountedItems = new ArrayList<>();
    }

    @Override
    public void calculateDiscount(Sale sale) {
       /*

        int length = itemId.length;
        double itemPrice = 0;
        int itemQuantity = 0;
        int i = 0;
        int j = 0;
        while (i < length && j != limit) {
            if (sale.getSaleDetail().getGoods().containsKey(itemId[i])) {
                itemQuantity = sale.getSaleDetail().getGoods().get(itemId[i]).getQuantity();
                if (itemQuantity >= requiredAmountOfItems) {
                    discountedItems.add(sale.getSaleDetail().getGoods().get(itemId));
                    itemPrice = sale.getSaleDetail().getGoods().get(itemId[i]).getItemPrice();
                    totalPriceReduction += itemPrice * reduction;
                    j++;
                }
            }
            i++;
        }

        return new BuyNItemsGetMFree(this);
        */
    }

    @Override
    public String getDiscountClass() {
        return discountClass;
    }

    public String getDiscountType() {
        return null;
    }

    @Override
    public double getTotalPriceReduction() {
        return totalPriceReduction;
    }

}
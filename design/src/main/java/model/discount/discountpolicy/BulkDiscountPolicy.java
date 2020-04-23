package model.discount.discountpolicy;

import model.sale.Sale;

/**
 * Class BulkDiscount derived from DiscountPolicy. It should
 * have a constructor that has two parameters, minimum and percent. It should define the method
 * computeDiscount so that if the quantity purchased of an item is more than minimum, the discount
 * is "percent" percent.
 **/

public class BulkDiscountPolicy extends DiscountPolicy {
    private final String discountClass = "Item discount";
    private final String discountType = "Bulk discount";
    private final double reduction;
    private final int minimumAmountOfItems;
    private final int limit;
    private final int itemId;
    private double totalPriceReduction;

    public void setTotalPriceReduction(double totalPriceReduction) {
        this.totalPriceReduction = totalPriceReduction;
    }

    public BulkDiscountPolicy(int itemId, int minimumAmountOfItems, int limit, double priceReduction) {
        this.reduction = priceReduction;
        this.itemId = itemId;
        this.minimumAmountOfItems = minimumAmountOfItems;
        this.limit = limit;

    }

    public double getReduction() {
        return reduction;
    }

    public int getMinimumAmountOfItems() {
        return minimumAmountOfItems;
    }

    public int getItemId() {
        return itemId;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public void calculateDiscount(Sale sale) {
       /*
        int length = itemId.length;
        double itemPrice = 0;
        int itemQuantity;
        int i = 0;


            while (i < length && i != limit) {
                totalPriceReduction = 0;
                try {
                    itemQuantity = sale.getCart().getItem(itemId[i]).getQuantity();
                } catch (NotFoundException ex){
                    continue;
                }

                if (itemQuantity >= minimumAmountOfItems) {
                    itemPrice = sale.getCart().getItem(itemId[i]).getProduct().getTotalPrice();
                    totalPriceReduction += itemPrice * reduction;
                    try {
                        sale.getCart().getItem(itemId[i]).setItemDiscount(new BulkDiscount(this));
                    } catch (IllegalDiscountCombinationException exp){
                        continue;
                    }
                }
                i++;
            }

        */
    }

    @Override
    public String getDiscountClass() {
        return discountClass;
    }

    public String getDiscountType() {
        return null;
    }

    public double getTotalPriceReduction() {
        return totalPriceReduction;
    }
}

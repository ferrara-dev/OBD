package service.discountservice.discountpolicy;

import model.discountmodel.discounttypes.itemdiscount.BulkDiscount;
import model.itemmodel.Product;
import model.salemodel.Sale;

import java.util.ArrayList;
import java.util.List;

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
    private final int[] itemId;
    private double totalPriceReduction;
    private List<Product> discountedItems;

    public BulkDiscountPolicy(int[] itemId, int minimumAmountOfItems, int limit, double priceReduction) {
        this.reduction = priceReduction;
        this.itemId = itemId;
        this.minimumAmountOfItems = minimumAmountOfItems;
        this.limit = limit;
        discountedItems = new ArrayList<>();
    }

    public double getReduction() {
        return reduction;
    }

    public int getMinimumAmountOfItems() {
        return minimumAmountOfItems;
    }

    public int[] getItemId() {
        return itemId;
    }

    public int getLimit() {
        return limit;
    }

    public List<Product> getDiscountedItems() {
        return discountedItems;
    }

    @Override
    public BulkDiscount calculateDiscount(Sale sale) {
        /*
        int length = itemId.length;
        double itemPrice = 0;
        int itemQuantity;
        int i = 0;
        while (i < length && i != limit) {
            itemQuantity = sale.getSaleDetail().getGoods().get(itemId[i]).getQuantity();
            if (itemQuantity >= minimumAmountOfItems) {
                discountedItems.add(sale.getSaleDetail().getGoods().get(itemId[i]));
                itemPrice = sale.getSaleDetail().getGoods().get(itemId[i]).getTotalPrice();
                totalPriceReduction += itemPrice * reduction;
            }
            i++;
        }
        return new BulkDiscount(this);

         */
        return null;
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

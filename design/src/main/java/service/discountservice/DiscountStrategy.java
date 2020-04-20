package service.discountservice;


import integration.datatransferobject.DiscountDTO;
import service.discountservice.discountpolicy.BulkDiscountPolicy;
import service.discountservice.discountpolicy.BuyNItemsGetMFreePolicy;
import service.discountservice.discountpolicy.DiscountPolicy;
import service.discountservice.discountpolicy.PriceDiscountPolicy;

/**
 * Service class that is used to create instances of <code> DiscountPolicy </code>
 * based on the type that is given in the <code> DiscountDTO </code> that has been
 * fetched from the discount database.
 */
public class DiscountStrategy {
    private final String BULK_DISCOUNT = "Bulk Discount";
    private final String GET_FREE_ITEM = "Buy N Items Get N Free";
    private final String PRICE_DISCOUNT = "Price Discount";

    private DiscountDTO discountDTO;

    /**
     * Creates an instance of a strategy that is applied
     * on specific type of discount
     * @param discountDTO the discount that the strategy is
     *                    applied on
     */
    public DiscountStrategy(DiscountDTO discountDTO){
        this.discountDTO = discountDTO;
    }


    /**
     * Method used to create a discount policy based on
     * the <code> discountDTO </code> and its attributes
     * @return the generated discount policy
     */
    public DiscountPolicy generateDiscountPolicy(){
        String discountType = discountDTO.getType();
        String [] discountItemId = discountDTO.getItemId().split(":");

        switch (discountType) {
            case BULK_DISCOUNT :{
                DiscountPolicy bulkDiscount =  createBulkDiscount(discountItemId);

                return createBulkDiscount(discountItemId);
            }

            case GET_FREE_ITEM :{
                return createBuyNItemsGetNFreeDiscount(discountItemId);
            }

            case PRICE_DISCOUNT :{
                return createPriceDiscount();
            }
        }

        return null;
    }

    private DiscountPolicy createPriceDiscount() {
        double minimumSpent = Double.parseDouble(discountDTO.getRequirement());
        double priceReduction = Double.parseDouble(discountDTO.getReduction());
        return new PriceDiscountPolicy(minimumSpent,priceReduction);
    }

    private DiscountPolicy createBulkDiscount(String [] discountItemId){
        int [] itemId = new int[discountItemId.length];
        for(int i = 0; i<itemId.length; i++)
            itemId[i] = Integer.parseInt(discountItemId[i]);
        int minimumAmountOfItems = Integer.parseInt(discountDTO.getRequirement());
        int limit = Integer.parseInt(discountDTO.getLimit());
        double priceReduction = Double.parseDouble(discountDTO.getReduction());
        return new BulkDiscountPolicy(itemId, minimumAmountOfItems, limit, priceReduction);
    }

    private DiscountPolicy createBuyNItemsGetNFreeDiscount(String [] discountItemId){
        int [] itemId = new int[discountItemId.length];
        for(int i = 0; i<itemId.length; i++)
            itemId[i] = Integer.parseInt(discountItemId[i]);
        int requiredAmountOfItems = Integer.parseInt(discountDTO.getRequirement());
        int limit = Integer.parseInt(discountDTO.getLimit());
        double priceReduction = Double.parseDouble(discountDTO.getReduction());
        return new BuyNItemsGetMFreePolicy(requiredAmountOfItems,itemId,limit,priceReduction);
    }

}

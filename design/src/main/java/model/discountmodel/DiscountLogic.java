package model.discountmodel;


import integration.discountdb.DiscountDTO;
import model.salemodel.SaleDetail;

import java.util.List;

public class DiscountLogic {
    static private final String PRODUCT_DISCOUNT = "Product discount";
    static private final String THREE_FOR_TWO_DISCOUNT = "Buy-3-pay-2";
    static private double totalPriceReduction = 0;
    static SaleDetail saleDetails;

    public static double ApplyDiscountLogic(SaleDetail saleDetail, List<DiscountDTO> discounts) {

        saleDetails = saleDetail;
        totalPriceReduction = 0;
        for (DiscountDTO discountDTO : discounts) {
            if (discountDTO.getType().equals(PRODUCT_DISCOUNT)) {
                if (discountDTO.getRequirement().equals(THREE_FOR_TWO_DISCOUNT)) {
                    calculateThreeForTwoDiscount(Integer.parseInt(discountDTO.getItemId()));
                } else if (discountDTO.getRequirement().equals("On given item")) {
                    calculateReducedPriceProductDiscount(Integer.parseInt(discountDTO.getItemId()));
                }
            }
        }
        applyDiscount(totalPriceReduction);
        return totalPriceReduction;
    }
    private static void applyDiscount(double priceReduction){
        System.out.println(saleDetails.getRunningTotal());
        saleDetails.updateRunningTotal(priceReduction);
        System.out.println(saleDetails.getRunningTotal());
    }
    private static void calculateThreeForTwoDiscount(int itemId) {
        final int requirement = 3;
        int id = itemId;
        if (saleDetails.getProcessedGoods().contains(id)) {
            int quantity =  saleDetails.getProcessedGoods().getItem(id).quantity;
            double price =  saleDetails.getProcessedGoods().getItem(id).totalPrice / quantity;
            if (quantity >= 3)
                for (int i = 3; i <= quantity; i++) {
                    System.out.println(i % 3);
                    if (i % 3 == 0)
                        totalPriceReduction = totalPriceReduction - price;
                }
        }
    }

    private static void calculateReducedPriceProductDiscount(int itemId){
        int id = itemId;
        if (saleDetails.getProcessedGoods().contains(id)){
            double price = (0.2) *  saleDetails.getProcessedGoods().getItem(id).totalPrice;
            totalPriceReduction = totalPriceReduction - price;
        }
    }

    /*
    String calculateDiscount(int itemId, final String type) {
        totalPriceReduction = 0;
        System.out.println(type);
        switch (type) {
            case TWENTY_OF: {
                if (saleDetail.getProcessedGoods().contains(itemId)) {
                    discount_rate = - 0.2;
                    totalPriceReduction = discount_rate * saleDetail.getProcessedGoods().getItem(itemId).totalPrice;
                    break;
                }
            }
            case THREE_FOR_TWO: {
                if (saleDetail.getProcessedGoods().contains(itemId)) {
                    int quantity = (saleDetail.getProcessedGoods().getItemQuantity(itemId));
                    System.out.println(quantity);
                    if(quantity >= 3)
                        for (int i = 3; i <= quantity; i++) {
                            System.out.println(i % 3);
                            if (i % 3 == 0)
                                totalPriceReduction += (-1)*saleDetail.getProcessedGoods().getItem(itemId).totalPrice / (quantity);
                        }

                    break;
                }
            }
            default:
                return "";
        }


        return "Total discount : " + totalPriceReduction + "\n" +
                "Previous running total : " + saleDetail.getRunningTotal() + "\n" +
                "New Running total : " + updateRunningTotal();
    }
    */
    /*
    private double updateRunningTotal(){
        return  saleDetail.updateRunningTotal(totalPriceReduction);
    }

    public void setSaleDetail(SaleDetail saleDetail){
        this.saleDetail = saleDetail;
    }
    */
}

package model.sale;
import model.AbstractModel;
import model.discount.discounttypes.pricediscount.PriceDiscount;
import model.listener.saleprocess.SaleCostListener;
import util.IllegalDiscountCombinationException;

import java.util.List;
import java.util.Objects;

public class Cost extends AbstractModel {
    PriceDiscount priceDiscount;
    List<SaleCostListener> costListeners;
    private double totalCost = 0;
    private double totalVAT = 0;

    public void updateCost(Sale sale){
        for(int i = 0; i < sale.getCart().size(); i++) {
            totalCost = sale.getCart().get(i).getTotalPrice();
            totalVAT = sale.getCart().get(i).getTotalVAT();
        }

        if(Objects.nonNull(priceDiscount)){
                totalCost = totalCost - priceDiscount.getTotalPriceReduction();
            }
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public void setPriceDiscount(PriceDiscount priceDiscount){
        if(Objects.isNull(this.priceDiscount))
            if(Objects.nonNull(priceDiscount))
                 this.priceDiscount = priceDiscount;
        else
            throw new IllegalDiscountCombinationException("Only one price discount can be applied per sale");

    }

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    public void addCostListeners(SaleCostListener saleCostListener){
        costListeners.add(saleCostListener);
    }
}

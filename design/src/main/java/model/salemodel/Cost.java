package model.salemodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Objects;
public class Cost implements PropertyChangeListener, Serializable {
    private double totalCost = 0;
    private double totalVAT = 0;

    public void updateCost(Sale sale){
        for(int i = 0; i < sale.getCart().size(); i++) {
            totalCost = sale.getCart().get(i).getTotalPrice();
            totalVAT = sale.getCart().get(i).getTotalVAT();
        }

        if(Objects.nonNull(sale.getSaleDetail().getDiscount()))
            totalCost = totalCost - sale.getSaleDetail().getDiscount().getTotalPriceReduction();
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

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

package model.salemodel;

import java.util.Objects;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.Serializable;
public class Cost implements PropertyChangeListener, Serializable {

    private double totalCost = 0;
    private double totalVAT = 0;


    public void updateCost(Sale sale){
        for(int i = 0; i < sale.getCart().getSize(); i++) {
            totalCost = sale.getCart().getElementAt(i).getTotalPrice();
            totalVAT = sale.getCart().getElementAt(i).getTotalVAT();
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

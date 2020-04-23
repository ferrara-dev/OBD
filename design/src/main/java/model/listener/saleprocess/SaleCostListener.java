package model.listener.saleprocess;

import model.listener.ModelListener;

public interface SaleCostListener extends ModelListener {
    void totalCostHasChanged(double newTotalCost, double newTotalVAT);
}

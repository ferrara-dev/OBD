package model.sale;


import model.AbstractModel;
import model.discount.Discount;
import model.listener.ModelListener;
import model.listener.saleprocess.SaleListener;
import model.listener.saleprocess.SaleProgressListener;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sale extends AbstractModel {
    private List<Discount> discounts;
    private List<SaleListener> saleListeners;
    private SaleDetail saleDetail;
    private Cart cart;
    private Cost cost;
    private double runningTotal = 0;
    private double cashBack = 0;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */
    public Sale() {

    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void addSaleListener(SaleListener saleListener){
        if(saleListeners == null)
            saleListeners = new ArrayList<>();
        saleListeners.add(saleListener);
    }

    @Override
    public PropertyChangeListener [] getPropertyChangeListeners(){
        return super.getPropertyChangeListeners();
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public Cost getCost() {
        return cost;
    }

    public void updateCost() {
        cost.updateCost(this);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void createDefault(){
        this.cart = new Cart();
        this.cost = new Cost();
        this.saleDetail = new SaleDetail();
        saleDetail.createDefault();
        /*
        for(PropertyChangeListener listener : listeners){
            cart.addPropertyChangeListener(listener);
            cost.addPropertyChangeListener(listener);
            saleDetail.addPropertyChangeListener(listener);
        }
*/

    }
    public void createDefault(ModelListener modelListener){
        this.cart = new Cart();
        this.cost = new Cost();
        this.saleDetail = new SaleDetail();
        saleDetail.addSaleProgressListener((SaleProgressListener) modelListener);
        saleDetail.createDefault();
        /*
        for(PropertyChangeListener listener : listeners){
            cart.addPropertyChangeListener(listener);
            cost.addPropertyChangeListener(listener);
            saleDetail.addPropertyChangeListener(listener);
        }
*/

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if(Objects.isNull(saleDetail))
            saleDetail = new SaleDetail();
        saleDetail.addPropertyChangeListener(listener);
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Method used to initiate fields to default values in a newly started sale
     */
    public SaleDetail getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(SaleDetail saleDetail) {
        this.saleDetail = saleDetail;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public double getRunningTotal() {
        return runningTotal;
    }


}

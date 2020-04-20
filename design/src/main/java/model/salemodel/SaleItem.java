package model.salemodel;

import model.AbstractModel;
import model.itemmodel.Product;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SaleItem extends AbstractModel {
    private final Product product;
    private double totalPrice;
    private double totalVAT;
    private int quantity;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public SaleItem(Product product){
        this.product = product;
        quantity = 1;
        totalVAT = product.getTotalVAT();
        totalPrice = product.getTotalPrice();
    }

    public SaleItem(SaleItem saleItem){
        product = saleItem.getProduct();
        quantity = saleItem.getQuantity();
        totalVAT = saleItem.getTotalVAT();
        totalPrice = saleItem.getTotalPrice();
    }

    public void update(int increasedQuantity){
       /* if(Objects.nonNull(this) && Objects.nonNull(product)) {
            int newQuantity = quantity + increasedQuantity;
            double newTotalPrice = product.getTotalPrice() * newQuantity;
            double newTotalVAT = product.getTotalVAT() * newQuantity;
            setQuantity(newQuantity);
            setTotalPrice(newTotalPrice);
            setTotalVAT(newTotalVAT);
        }********/
        int newQuantity = quantity + increasedQuantity;
        double newTotalPrice = product.getTotalPrice() * newQuantity;
        double newTotalVAT = product.getTotalVAT() * newQuantity;
        setQuantity(newQuantity);
        setTotalPrice(newTotalPrice);
        setTotalVAT(newTotalVAT);
    }

    public SaleItem copy(SaleItem saleItem){
        return new SaleItem(saleItem);
    }

    public void setQuantity(int quantity){
        pcs.firePropertyChange("quantity", this.quantity, quantity);
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        pcs.firePropertyChange("totalPrice", this.totalPrice, totalPrice);
        this.totalPrice = totalPrice;
    }

    public void setTotalVAT(double totalVAT) {
        pcs.firePropertyChange("totalVAT", this.totalVAT, totalVAT);
        this.totalVAT = totalVAT;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

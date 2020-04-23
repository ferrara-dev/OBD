package model.item;
import model.AbstractModel;
import model.discount.discounttypes.itemdiscount.ItemDiscount;
import util.IllegalDiscountCombinationException;

import java.beans.PropertyChangeListener;
import java.util.Objects;

public class SaleItem extends AbstractModel {
    private final Product product;
    private ItemDiscount itemDiscount;
    private double totalPrice;
    private double totalVAT;
    private int quantity;

    public SaleItem(Product product){
        this.product = product;
        setQuantity(1);
        totalVAT = product.getTotalVAT();
        totalPrice = product.getTotalPrice();
    }

    /**
     * Set the item discount
     * if <code> itemDiscount == null </code> or <code> this.itemDiscount</code>
     * has a lower price reduction the <code> @param itemDiscount </code> the
     * discount is set to the value of <code> @param itemDiscount </code>.
     * else <code> IllegalDiscountCombinationException </code> is thrown
     * and needs to be handled by the caller.
     * @param itemDiscount the discount that is to be applied to the saleItem.
     */
    public void setItemDiscount(ItemDiscount itemDiscount){
        if(itemDiscount == null || (this.itemDiscount.getTotalPriceReduction() < itemDiscount.getTotalPriceReduction()))
            this.itemDiscount = itemDiscount;
        else
            throw new IllegalDiscountCombinationException();
    }

    public SaleItem(SaleItem saleItem){
        product = saleItem.getProduct();
        quantity = saleItem.getQuantity();
        totalVAT = saleItem.getTotalVAT();
        totalPrice = saleItem.getTotalPrice();
    }

    public void update(int increasedQuantity){
        if(Objects.nonNull(this) && Objects.nonNull(product)) {
            int newQuantity = quantity + increasedQuantity;
            double newTotalPrice = product.getTotalPrice() * newQuantity;
            double newTotalVAT = product.getTotalVAT() * newQuantity;
            setQuantity(newQuantity);

            if(itemDiscount != null){
                newTotalPrice = newTotalPrice - itemDiscount.getTotalPriceReduction();
            }

            setTotalPrice(newTotalPrice);
            setTotalVAT(newTotalVAT);

        }
    }

    public SaleItem copy(SaleItem saleItem){
        return new SaleItem(saleItem);
    }

    public void setQuantity(int quantity){
        super.firePropertyChange("quantity", this.quantity, quantity);
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        super.firePropertyChange("totalPrice", this.totalPrice, totalPrice);
        this.totalPrice = totalPrice;
    }

    public void setTotalVAT(double totalVAT) {
        super.firePropertyChange("totalVAT", this.totalVAT, totalVAT);
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

    public void addPropertyChangeListener(PropertyChangeListener [] listeners) {
        for(PropertyChangeListener listener: listeners)
            super.addPropertyChangeListener(listener);
    }
/*
    public void fireInitialProperties(){
        firePropertyChange(PersonController.AGE_PROPERTY, null, age);
        firePropertyChange(PersonController.FIRSTNAME_PROPERTY, null, firstname);
        firePropertyChange(PersonController.SURNAME_PROPERTY, null, surname);
    }


 */
}

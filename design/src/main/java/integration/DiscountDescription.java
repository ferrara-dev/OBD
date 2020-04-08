package integration;



public class DiscountDescription {
    public String type;
    public String description;
    public ItemDetail discountItem;

    public DiscountDescription(int id) {
        discountItem = RegestryCreator.getItemRegestry().getItemDetail(id);
    }
}

package integration.discountdb;


public class DiscountDTO {
    private String type;
    private String available;
    private String requirement;
    private String reduction;
    private String limit;
    private String itemId;
    public String validMembers [];

    public DiscountDTO(String type, String itemId, String available, String requirement, String reduction ,String limit)
    {
        this.type = type;
        this.itemId = itemId;
        this.available = available;
        this.requirement = requirement;
        this.reduction = reduction;
        this.limit = limit;
    }


    public String getType() {
        return type;
    }

    public String getItemId(){
        return itemId;
    }

    public String getAvailable() {
        return available;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getReduction() {
        return reduction;
    }

    public String getLimit() {
        return limit;
    }
}

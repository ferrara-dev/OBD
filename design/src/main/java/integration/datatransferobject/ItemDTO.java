package integration.datatransferobject;

public class ItemDTO {
    private String name;
    private String category;
    private double price;
    private int stockStatus;
    private int itemId;


    public ItemDTO(String name, double price, String category, int itemId, int stockStatus){
        this.name = name;
        this.category = category;
        this.price = price;
        this.category = category;
        this.itemId = itemId;
        this.stockStatus = stockStatus;
    }

    public ItemDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}

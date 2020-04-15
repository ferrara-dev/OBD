package integration.productdb;

public class ItemDTO {
    private String name;
    private String category;
    private double price;
    private int stockStatus;
    private int itemId;
    private int quantity;

    public ItemDTO(String name, double price, String category, int itemId, int stockStatus, int quantity){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockStatus = stockStatus;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}

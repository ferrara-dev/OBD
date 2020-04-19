package integration.productdb;

public class ItemDTO {
    private String name;
    private String category;
    private double price;
    private int stockStatus;
    private int itemId;
<<<<<<< HEAD
    private int quantity;

    public ItemDTO(String name, double price, String category, int itemId, int stockStatus, int quantity){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockStatus = stockStatus;
        this.itemId = itemId;
        this.quantity = quantity;
=======


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
>>>>>>> origin/master
    }

    public String getCategory() {
        return category;
    }

<<<<<<< HEAD
=======
    public void setCategory(String category) {
        this.category = category;
    }

>>>>>>> origin/master
    public double getPrice() {
        return price;
    }

<<<<<<< HEAD
=======
    public void setPrice(double price) {
        this.price = price;
    }

>>>>>>> origin/master
    public int getStockStatus() {
        return stockStatus;
    }

<<<<<<< HEAD
    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
=======
    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
>>>>>>> origin/master
    }
}

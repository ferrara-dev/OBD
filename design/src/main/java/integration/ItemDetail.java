package integration;

public class ItemDetail {
    public String name;
    public String category;
    public double price;
    public int stockStatus;
    public int itemId;

    public ItemDetail(String name, double price, String category, int itemId, int stockStatus) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.itemId = itemId;
        this.stockStatus = stockStatus;
    }
    /*
    public int getItemId() {
        return itemId;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public String getName() {
        return name;
    }

    public String getCategory(){
        return category;
    }

    public double getPrice() {
        return price;
    }

*/
    @Override
    public String toString() {
        return "ItemDetail{" +
                "name='" + name + '\'' +
                ", id=" + itemId +
                ", price=" + price +
                ", Stock status=" + stockStatus +
                '}';
    }
}


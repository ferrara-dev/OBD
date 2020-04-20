package view.cashierview.io.beanobject;

import model.itemmodel.Product;

import java.util.ArrayList;
public class ItemBean {
    private String name;
    private int itemId;
    private double price;
    private int quantity = 1;
    private double totalPrice = 0;
    private String category;
    private double taxRate;
    private double totalVAT;
    private double itemPrice;

    public ItemBean(ArrayList<Product> modelList){
        for(Product item: modelList) {
            quantity++;
            totalPrice = item.getPrice();
        }

    }
}

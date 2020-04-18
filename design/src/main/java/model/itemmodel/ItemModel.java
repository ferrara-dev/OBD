package model.itemmodel;

import integration.productdb.ItemDTO;

public class ItemModel {
        private String name;
        private int itemId;
        private double price;
        private int quantity = 1;
        private double totalPrice;
        private String category;
        private double taxRate;
        private double totalVAT;
        private double itemPrice;

        public ItemModel(){

        }

        public void createItemModel(ItemDTO itemDTO){
                price = itemDTO.getPrice();
                itemId = itemDTO.getItemId();
                name = itemDTO.getName();
                category = itemDTO.getCategory();
                setTaxRate();
                setTotalVAT(taxRate * price);
                setTotalPrice();
        }

        public double getTotalVAT() {
                return totalVAT;
        }

        public void setTotalVAT(double totalVAT) {
                this.totalVAT = totalVAT;
        }


        public void setItemId(int itemId) {
                this.itemId = itemId;
        }


        public void setPrice(double price) {
                this.price = price;
        }


        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }


        public void setTotalPrice() {
                totalPrice = quantity*price*(taxRate + 1);
        }


        public void setCategory(String category) {
                this.category = category;
        }


        public void setTaxRate() {
                this.taxRate = Tax.getTax(this);
        }


        public String toString(){
                return  "Item :  " + this.name + "\n" +
                        "Quantity : " + this.quantity + "\n" +
                        "Total price : " + this.totalPrice + "\n" +
                        "Which of tax : " + taxRate*totalPrice;
        }


        public String getName() {
                return name;
        }

        public void setTaxRate(double taxRate) {
                this.taxRate = taxRate;
        }

        public void setItemPrice(double itemPrice) {
                this.itemPrice = itemPrice;
        }

        public void setTotalPrice(double totalPrice) {
                this.totalPrice = totalPrice;
        }

        public int getItemId() {
                return itemId;
        }


        public double getPrice() {
                return price;
        }

        public int getQuantity() {
                return quantity;
        }


        public double getTotalPrice() {
                return totalPrice;
        }


        public String getCategory() {
                return category;
        }


        public double getTaxRate() {
                return taxRate;
        }


        private void calcTotalPrice(){
                totalPrice = quantity*price*(taxRate + 1);
        }


        public void setName(String name) {
                this.name = name;
        }

        public double getItemPrice(){
                return totalPrice/quantity;
        }
}

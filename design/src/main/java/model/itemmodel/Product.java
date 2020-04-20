package model.itemmodel;

import integration.datatransferobject.ItemDTO;

public class Product {
        private String name;
        private int itemId;
        private double price;
        private String category;
        private double totalVAT;
        private double taxRate;
        private double totalPrice;

        public Product(){

        }

        public void setAttributes(ItemDTO itemDTO){
                name = itemDTO.getName();
                itemId = itemDTO.getItemId();
                price = itemDTO.getPrice();
                category = itemDTO.getCategory();
                taxRate = Tax.getTax(this);
                totalVAT = taxRate * price;
                totalPrice = totalVAT + price;
        }

        public void createItemModel(ItemDTO itemDTO){
                price = itemDTO.getPrice();
                itemId = itemDTO.getItemId();
                name = itemDTO.getName();
                category = itemDTO.getCategory();
                setTaxRate();
                setTotalVAT(taxRate * price);
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

        public void setCategory(String category) {
                this.category = category;
        }

        public void setTaxRate() {
                this.taxRate = Tax.getTax(this);
        }

        public String getName() {
                return name;
        }

        public void setTaxRate(double taxRate) {
                this.taxRate = taxRate;
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

        public double getTotalPrice() {
                return totalPrice;
        }

        public String getCategory() {
                return category;
        }

        public double getTaxRate() {
                return taxRate;
        }

        public void setName(String name) {
                this.name = name;
        }


        public boolean equals(Product product){
                if(this == product)
                        return true;
                else if(this.itemId == product.getItemId())
                        return true;
                return false;
        }
}

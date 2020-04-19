package service.saleservice;

import integration.DBService;
import integration.Printer;
import integration.productdb.ItemDTO;
import java.util.HashMap;
import java.util.Objects;
import model.discountmodel.Discount;
import model.itemmodel.ItemModel;
import model.physicalobjects.Receipt;
import model.salemodel.Sale;
import service.inventoryservice.ItemService;
import util.NotFoundException;


public class SaleService {
    Sale sale;
    ItemService itemService;

    public SaleService() {
        itemService = new ItemService();
    }

    public String finalizeSale() {
        Receipt receipt = new Receipt(sale);
        DBService.logSale(sale.getSaleDetail().getSaleId().getValue(), sale);
        setSale(null);
        return Printer.print(receipt);
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }

    public void startSale() {
        sale = new Sale();
        sale.createDefault();
    }

    /**
     * applies a discount that has been calculated by the discount service to the current sale
     * @param discount the discount that is applied
     */
    public void applyDiscountToSale(Discount discount) {
        sale.getSaleDetail().setDiscount(discount);
        updateRunningTotal(discount.getTotalPriceReduction()*-1);
    }

    public String registerItem(ItemDTO itemDTO, int quantity) {
        if (Objects.isNull(sale)) {
            startSale();
        }

        if (!sale.getSaleDetail().isCompleted())
            if (sale.getSaleDetail().isActive()) {
                ItemModel saleLineItem = itemService.createItemModel(itemDTO, quantity);
                int itemId = itemDTO.getItemId();
                addSaleLineItem(saleLineItem);

                double itemVAT = sale.getSaleDetail().getGoods().get(itemId).getTotalVAT();
                double price = sale.getSaleDetail().getGoods().get(itemId).getTotalPrice();
                updateTotalVAT(itemVAT);
                updateRunningTotal(price);
            }

        return sale.saleDetailAsString();
    }

    public void updateRunningTotal(double amount) {
        double newTotal = sale.getRunningTotal() + amount;
        sale.setRunningTotal(newTotal);

        if (!sale.getSaleDetail().isCompleted())
            sale.setTotalCost(sale.getRunningTotal());
    }

    public ItemModel getRegisteredItem(int itemId){
        ItemModel registeredItem = sale.getSaleDetail().getGoods().get(itemId);
        if(Objects.isNull(registeredItem))
            throw new NotFoundException("Item has not been registered");
        return sale.getSaleDetail().getGoods().get(itemId);
    }

    public String endSale() {
        sale.getSaleDetail().setCompleted(true);
        double totalCost = sale.getRunningTotal();
        sale.setTotalCost(totalCost);
        return Double.toString(sale.getTotalCost());
    }

    private void updateTotalVAT(double amount) {
        double newVAT = sale.getTotalVAT() + amount;
        sale.setTotalVAT(newVAT);
    }

    private void addSaleLineItem(ItemModel saleLineItem) {
        if (Objects.isNull(saleLineItem))
            throw new IllegalStateException("There must be an saleLineItem to register");

        HashMap<Integer,ItemModel> goods = sale.getSaleDetail().getGoods();
        int itemId = saleLineItem.getItemId();
        if (goods.containsKey(itemId)) {
            int newQuantity = goods.get(itemId).getQuantity() + saleLineItem.getQuantity();
            goods.get(itemId).setQuantity(newQuantity);
        }
        else
            goods.put(itemId,saleLineItem);

        sale.getSaleDetail().setGoods(goods);
    }

}

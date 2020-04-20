package service.saleservice;

import integration.DBService;
import integration.Printer;
import java.util.HashMap;
import java.util.Objects;
import model.discountmodel.Discount;
import model.itemmodel.Product;
import model.physicalobjects.Receipt;
import model.salemodel.Sale;
import model.salemodel.SaleItem;
import service.inventoryservice.ItemService;


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

    public String registerItem(Product product, int quantity) {
        if (Objects.isNull(sale)) {
            startSale();
        }
        if (!sale.getSaleDetail().isCompleted())
            if (sale.getSaleDetail().isActive()) {
                sale.getCart().add(product,quantity);
                sale.updateCost();
            }

        return sale.saleDetailAsString();
    }

    public void updateRunningTotal(double amount) {
        double newTotal = sale.getCost().getTotalCost();
        sale.setRunningTotal(newTotal);
    }

    public Sale endSale() {
        sale.getSaleDetail().setCompleted(true);
        return sale;
    }


/*
    private void addSaleItem(Product saleLineItem) {
        if (Objects.isNull(saleLineItem))
            throw new IllegalStateException("There must be an saleLineItem to register");

        HashMap<Integer, SaleItem> goods = sale.getSaleDetail().getGoods();
        int itemId = saleLineItem.getItemId();
        if (goods.containsKey(itemId)) {
            int newQuantity = goods.get(itemId).getQuantity() + saleLineItem.getQuantity();
            goods.get(itemId).update(newQuantity);
        }
        else
            goods.put(itemId,saleLineItem);

        sale.getSaleDetail().setGoods(goods);
    }
*/
}

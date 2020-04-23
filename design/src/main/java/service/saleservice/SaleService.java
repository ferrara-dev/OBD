package service.saleservice;

import integration.DBService;
import integration.Printer;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import model.discount.Discount;
import model.item.Product;
import model.listener.saleprocess.SaleCartListener;
import model.listener.ModelListener;
import model.listener.saleprocess.SaleProgressListener;
import model.physicalobjects.Receipt;
import model.sale.Sale;
import service.inventoryservice.ItemService;
import startup.ServiceFactory;


public class SaleService {
    Sale sale;
    ItemService itemService;

    public SaleService(ServiceFactory serviceFactory) {
        itemService =  serviceFactory.getItemService();
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

    public void startSale(List<ModelListener> modelListeners) {
        sale = new Sale();
        for (ModelListener modelListener : modelListeners) {
            if (modelListener instanceof SaleProgressListener) {
                sale.createDefault(modelListener);
                break;
            }
        }

        for (ModelListener modelListener : modelListeners) {
            if (modelListener instanceof SaleCartListener) {
                sale.getCart().addSaleCartListener((SaleCartListener) modelListener);
            }
        }
    }

    public void distributeSaleListeners(PropertyChangeListener propertyChangeListener) {
        sale.addPropertyChangeListener(propertyChangeListener);
        sale.getSaleDetail().addPropertyChangeListener(propertyChangeListener);
        sale.getCost().addPropertyChangeListener(propertyChangeListener);
    }

    public Sale registerItem(Product product, int quantity) {
        if (Objects.isNull(sale)) {
            throw new IllegalStateException();
            // startSale();
        }

        if (!sale.getSaleDetail().isCompleted())
            if (sale.getSaleDetail().isActive()) {
                sale.getCart().add(product, quantity);
                sale.updateCost();
            }
        return sale;
    }

    public void updateRunningTotal() {
        double newTotal = sale.getCost().getTotalCost();
        sale.setRunningTotal(newTotal);
    }

    public Sale endSale() {
        sale.getSaleDetail().setCompleted(true);
        applyDiscounts();
        return sale;
    }

    private void applyDiscounts() {
        List<Discount> discountList = sale.getDiscounts();
        double priceReduction = 0;
        if (discountList == null)
            return;

        sale.updateCost();
        updateRunningTotal();
    }

}

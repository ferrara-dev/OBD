package view.gui.cashierview.saleview;

import model.discount.Discount;
import model.listener.saleprocess.SaleListener;
import model.sale.Cost;
import net.miginfocom.swing.MigLayout;
import view.AbstractViewHandler;
import view.guiutil.ViewFactory;

public class SaleView extends AbstractViewHandler implements SaleListener {
    private ItemRegistrationView itemRegistrationView;
    private SaleProcessInputView inputView;
    private DiscountView discountView;
    private SaleProcessCostView saleProcessCostView;
    public SaleView(ViewFactory viewFactory){
        super(viewFactory);
        itemRegistrationView = new ItemRegistrationView(viewFactory);
        discountView = new DiscountView();
        inputView = new SaleProcessInputView(viewFactory);
        saleProcessCostView = new SaleProcessCostView(viewFactory);

        setLayout(new MigLayout());
      // "cell column row width height"panel.add(comp3, "cell 3 0");panel.add(comp4, "cell 0 1 4 1");

        add(itemRegistrationView,"cell 0 0 4 2");
       // add(discountView, "cell 1 0 2");
        add(saleProcessCostView,"cell  0 4 4 1");
        add(inputView, "cell 0 8 4 2");
       // add(saleProcessCostView,"dock south, grow");
      //  add(itemRegistrationView,"dock south, gaptop 10");


    }

    public ItemRegistrationView getItemRegistrationView() {
        return itemRegistrationView;
    }

    @Override
    public void runningTotalHasChanged(double runningTotal) {

    }

    @Override
    public void discountWasApplied(Discount appliedDiscount) {

    }

    @Override
    public void costHasChanged(Cost IncreasedCost) {

    }

}

package view.gui.cashierview.saleview;

import model.item.SaleItem;
import model.listener.saleprocess.SaleCartListener;
import net.miginfocom.swing.MigLayout;
import view.AbstractViewHandler;
import view.guiutil.SaleItemJTable;
import view.guiutil.ViewFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ItemRegistrationView extends AbstractViewHandler implements SaleCartListener{
    public static final String CARD_CONSTRAINT = "SaleView";
    private SaleItemJTable saleItemJTable;

    public ItemRegistrationView(ViewFactory viewFactory) {
        super(viewFactory);
        setBorder(BorderFactory.createLineBorder(Color.BLUE,2,true));
        saleItemJTable = new SaleItemJTable();
        setLayout(new MigLayout("fill"));
        add(saleItemJTable.getPanel(),"north, grow");
        addActionListeners();
    }

    public SaleItemJTable getSaleItemJTable() {
        return saleItemJTable;
    }

    private void addActionListeners() {

    }

    @Override
    public void saleItemListChanged(List<SaleItem> registredItems) {
        saleItemJTable.setCard(registredItems);
    }

    @Override
    public void saleItemStateUpdated(SaleItem saleItem, int row) {
        saleItemJTable.getTableModel().addElementAt(row,saleItem);
        saleItemJTable.getTableModel().fireTableDataChanged();
    }

}



package view.gui.cashierview.startsaleview;

import net.miginfocom.swing.MigLayout;
import view.AbstractViewHandler;
import view.gui.ViewHandler;
import view.gui.cashierview.saleview.SaleView;
import view.guiutil.ViewFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartSaleView extends AbstractViewHandler  {
    public static final String CARD_CONSTRAINT = "InitialView";
    private JButton startSaleButton;
    public StartSaleView(ViewFactory viewFactory) {
        super(viewFactory);
        setLayout(new MigLayout());
        startSaleButton = new JButton("Start sale");
        setActionListener();
        add(startSaleButton, "center");

    }

    private void setActionListener() {
        startSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == startSaleButton) {
                    getSaleController().startSale();
                    getSaleController().addSaleProgressListener(getViewHandler());
                    getSaleController().addSaleListener(getSaleView());
                    getSaleController().addSaleCartListener(getSaleView().getItemRegistrationView());
                }
            }
        });
    }

}

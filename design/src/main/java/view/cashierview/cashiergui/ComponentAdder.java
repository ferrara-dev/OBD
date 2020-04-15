package view.cashierview.cashiergui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class ComponentAdder {
    GuiCreator creator;
    public ComponentAdder(GuiCreator creator){
        this.creator = creator;
        addComponents();
    }

    private void addComponents(){
        //Create the "cards".
        JPanel card1 = new JPanel(new MigLayout("fill"));
        card1.add(creator.getCashierGui().buttonHandler.getStartButton(), "center,span,grow");
        JPanel card2 = new JPanel();
        card2.setLayout(new MigLayout("wrap", "[fill, grow]", "[fill, grow][fill, grow]"));
        card2.add(creator.getCashierGui().displayPanel, "center,spany,push");
        creator.getCashierGui().displayPanel.addComponents("top",creator.getCashierGui().saleInformationLabel);
        creator.getCashierGui().displayPanel.addComponents("top, grow, push",creator.getCashierGui().textHandler.getSaleInformationArea());
        creator.getCashierGui().displayPanel.addComponents("top", creator.getCashierGui().itemIdLabel);
        creator.getCashierGui().displayPanel.addComponents("top",creator.getCashierGui().textHandler.getItemIdTextField());
        creator.getCashierGui().displayPanel.addComponents("top", new JLabel("quantity : "));
        creator.getCashierGui().displayPanel.addComponents("top", creator.getCashierGui().textHandler.getItemQuantityTextField());
        creator.getCashierGui().displayPanel.addComponents("top", creator.getCashierGui().customerIdLabel);
        creator.getCashierGui().displayPanel.addComponents("top",creator.getCashierGui().textHandler.getCustomerIdTextField());
        creator.getCashierGui().displayPanel.addComponents("top,span", creator.getCashierGui().buttonHandler.getRegisterItemButton());
        creator.getCashierGui().displayPanel.addComponents("top,span", creator.getCashierGui().buttonHandler.getEndSaleButton());
        creator.getCashierGui().displayPanel.addComponents("top,span", creator.getCashierGui().buttonHandler.getDiscountButton());

        JPanel card3 = new JPanel();
        card3.setLayout(new MigLayout("wrap", "[fill, grow]", "[fill, grow][fill, grow]"));
        card3.add(creator.getCashierGui().secondDisplayPanel, "center,spany,push");
        creator.getCashierGui().secondDisplayPanel.addComponents("top",creator.getCashierGui().endSaleLabel);
        JScrollPane jScrollPane = new JScrollPane(creator.getCashierGui().textHandler.getEndSaleTextArea());
        jScrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        creator.getCashierGui().secondDisplayPanel.addComponents("top, grow, push",jScrollPane);
        creator.getCashierGui().secondDisplayPanel.addComponents("top,span", new JLabel("Enter Payment"));
        creator.getCashierGui().secondDisplayPanel.addComponents("top,span", creator.getCashierGui().textHandler.getPaymentTextField());
        creator.getCashierGui().secondDisplayPanel.addComponents("top,span", creator.getCashierGui().buttonHandler.getPaymentButton());


        creator.getCashierGui().cards = new JPanel(new CardLayout());

        creator.getCashierGui().cards.add(card1, "card1");
        creator.getCashierGui().cards.add(card2, "card2");
        creator.getCashierGui().cards.add(card3, "card3");
        creator.getMainFrame().add(creator.getCashierGui().cards);

    }

}

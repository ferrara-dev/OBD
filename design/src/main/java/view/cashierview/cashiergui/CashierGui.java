package view.cashierview.cashiergui;

import view.cashierview.CashierView;
import view.cashierview.cashiergui.panels.*;

import javax.swing.*;
import java.awt.*;

public class CashierGui extends JFrame {
    private CashierView cashierView;
    DisplayPanel displayPanel;
    DisplayPanel secondDisplayPanel;
    JPanel cards;


    final JLabel customerIdLabel = new JLabel("Customer id :");
    final JLabel endSaleLabel = new JLabel("Total ");
    final JLabel receiptLabel = new JLabel("Receipt ");
    final JLabel itemIdLabel = new JLabel("Item id :");
    final JLabel saleInformationLabel = new JLabel("SaleInformation ");


    IOHandler ioHandler;
    ButtonHandler buttonHandler;
    TextHandler textHandler;

    public CashierView getCashierView() {
        return cashierView;
    }

    public TextHandler getTextHandler() {
        return textHandler;
    }

    public CashierGui(CashierView cashierView) throws Exception {
        this.cashierView = cashierView;
        ioHandler = new IOHandler(this);
        buttonHandler = new ButtonHandler();
        textHandler = new TextHandler();

        displayPanel = new DisplayPanel();
        secondDisplayPanel = new DisplayPanel();
        cards = new JPanel(new CardLayout());
        GuiCreator guiCreator = new GuiCreator(this);
        addActionListeners();
    }

    /**
     * Register an item and then goes on to update the text shown by the gui
     * @param itemId
     * @param quantity
     */
    public void registerItem(int itemId, int quantity){
        String outputInformation = cashierView.registerItem(itemId,quantity);
        updateSaleInformation(outputInformation);
    }

    /**
     * Ends the sale and switches card so that the secondDisplayPanel is displayed
     */
    public void endSale(){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
        String outPutInformation = cashierView.endSale();
        updateEndSaleTextArea(outPutInformation);
    }

    /**
     * Switches the card so that the first displayPanel is displayed,
     * then starts the sale by calling cashierView
     */

    public void startSale(){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
        cashierView.startSale();
    }

    /**
     * initiates a discount request by calling
     * the cashierView.
     * @param customerId identification number for whom
     *                   the discount is requested
     */
    public void signalDiscount(String customerId){
        cashierView.signalDiscountRequest(customerId);
    }

    /**
     * Call to cashierView to enter the payment made by the customer,
     * goes on to update the text on <code>secondDisplayPanel</code>
     */
    public void enterPayment(){
            String outputInformation = cashierView.enterPayment(Double.parseDouble(textHandler.getPaymentTextField().getText()));
            updateEndSaleTextArea(outputInformation);
    }
    private void addActionListeners() {
        buttonHandler.getStartButton().addActionListener(ioHandler::actionPerformed);
        buttonHandler.getRegisterItemButton().addActionListener(ioHandler::actionPerformed);
        buttonHandler.getEndSaleButton().addActionListener(ioHandler::actionPerformed);
        buttonHandler.getDiscountButton().addActionListener(ioHandler::actionPerformed);
        buttonHandler.getPaymentButton().addActionListener(ioHandler::actionPerformed);
    }

    private void updateSaleInformation(String displayMessage){
        textHandler.setSaleInformationArea(displayMessage);
    }

    private void updateEndSaleTextArea(String displayMessage){
        textHandler.setEndSaleTextArea(displayMessage);
    }
}


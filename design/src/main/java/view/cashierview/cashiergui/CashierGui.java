package view.cashierview.cashiergui;

import controller.DiscountController;
import controller.ItemController;
import controller.SaleController;
import startup.LayerCreator;
import view.cashierview.cashiergui.buttons.ButtonHandler;
import view.cashierview.cashiergui.panels.*;


import javax.swing.*;
import java.awt.*;


public class CashierGui extends JFrame {
    DisplayPanel displayPanel;
    DisplayPanel secondDisplayPanel;
    JPanel cards;


    final JLabel customerIdLabel = new JLabel("Customer id :");
    final JLabel endSaleLabel = new JLabel("Total ");
    final JLabel receiptLabel = new JLabel("Receipt ");
    final JLabel itemIdLabel = new JLabel("Item id :");
    final JLabel saleInformationLabel = new JLabel("SaleInformation ");


    InputHandler inputHandler;
    ButtonHandler buttonHandler;
    TextHandler textHandler;
    private SaleController saleController;
    private ItemController itemController;
    private DiscountController discountController;



    public SaleController getCashierView() {
        return saleController;
    }

    public TextHandler getTextHandler() {
        return textHandler;
    }

    public CashierGui(LayerCreator creator) throws Exception {
        saleController = creator.getSaleController();
        discountController = creator.getDiscountController();
        itemController = creator.getItemController();

        inputHandler = new InputHandler(this);
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
        String outputInformation = saleController.getCreator().getItemController().registerItem(itemId,quantity);
        updateSaleInformation(outputInformation);
    }

    /**
     * Ends the sale and switches card so that the secondDisplayPanel is displayed
     */
    public void endSale(){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
        saleController.endSale();
        updateEndSaleTextArea("outPutInformation");
    }

    /**
     * Switches the card so that the first displayPanel is displayed,
     * then starts the sale by calling cashierView
     */

    public void startSale(){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
        saleController.startSale();
    }

    /**
     * initiates a discount request by calling
     * the cashierView.
     * @param customerId identification number for whom
     *                   the discount is requested
     */
    public void signalDiscount(String customerId){
       discountController.signalDiscountRequest(customerId);
    }

    /**
     * Call to cashierView to enter the payment made by the customer,
     * goes on to update the text on <code>secondDisplayPanel</code>
     */
    public void enterPayment(){
            String outputInformation = saleController.enterPayment(Double.parseDouble(textHandler.getPaymentTextField().getText()));
            updateEndSaleTextArea(outputInformation);
    }
    private void addActionListeners() {
        buttonHandler.getStartButton().addActionListener(inputHandler::actionPerformed);
        buttonHandler.getRegisterItemButton().addActionListener(inputHandler::actionPerformed);
        buttonHandler.getEndSaleButton().addActionListener(inputHandler::actionPerformed);
        buttonHandler.getDiscountButton().addActionListener(inputHandler::actionPerformed);
        buttonHandler.getPaymentButton().addActionListener(inputHandler::actionPerformed);
    }

    private void updateSaleInformation(String displayMessage){
        textHandler.setSaleInformationArea(displayMessage);
    }

    private void updateEndSaleTextArea(String displayMessage){
        textHandler.setEndSaleTextArea(displayMessage);
    }
}


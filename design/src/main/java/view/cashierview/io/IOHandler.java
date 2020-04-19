package view.cashierview.cashiergui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import util.NotFoundException;
import view.cashierview.cashiergui.panels.GuiErrorMessage;

/**
 * class that handles input and output
 */
public class IOHandler implements ActionListener {
    CashierGui cashierGui;

    public IOHandler(CashierGui cashierGui) {
        this.cashierGui = cashierGui;
    }

    /**
     * Handles the action event and performs method call to
     * perform appropriate operations
     * @param e the event that has occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cashierGui.buttonHandler.getRegisterItemButton())
            if (textfieldIsNotEmpty(cashierGui.textHandler.getItemIdTextField()))
                registerItem();

        if (e.getSource() == cashierGui.buttonHandler.getPaymentButton())
            if (textfieldIsNotEmpty(cashierGui.textHandler.getPaymentTextField()))
                enterPayment();

        if (e.getSource() == cashierGui.buttonHandler.getDiscountButton())
            if (textfieldIsNotEmpty(cashierGui.textHandler.getCustomerIdTextField()))
                signalDiscount();

        if (e.getSource() == cashierGui.buttonHandler.getEndSaleButton())
            endSale();

        if (e.getSource() == cashierGui.buttonHandler.getStartButton())
            startSale();
    }

    private void registerItem() {
        try {
            int itemId = Integer.parseInt(cashierGui.textHandler.getItemIdTextField().getText());
            int quantity;
            if (!textfieldIsNotEmpty(cashierGui.textHandler.getItemQuantityTextField()))
                quantity = 1;
            else
                quantity = Integer.parseInt(cashierGui.textHandler.getItemQuantityTextField().getText());

            try {
                cashierGui.registerItem(itemId, quantity);
            } catch (NotFoundException ex) {
                GuiErrorMessage.getErrorPopUp(ex.ITEM_NOT_FOUND_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            GuiErrorMessage.getErrorPopUp(GuiErrorMessage.ITEM_INPUT_WRONG_FORMAT);
        }

    }

    private void enterPayment() {
        try {
            cashierGui.enterPayment();
        } catch (NumberFormatException ex) {
            GuiErrorMessage.getErrorPopUp(GuiErrorMessage.PAYMENT_INPUT_WRONG_FORMAT);
        }
    }

    private void signalDiscount() {
        String customerId = cashierGui.textHandler.getCustomerIdTextField().getText();
        try {
            String displayMessage = cashierGui.getCashierView().signalDiscountRequest(cashierGui.getCashierView().signalDiscountRequest(customerId));
            cashierGui.textHandler.getSaleInformationArea().setText(displayMessage);
        } catch (NotFoundException ex) {
            GuiErrorMessage.getErrorPopUp(GuiErrorMessage.CUSTOMER_NOT_FOUND_MESSAGE);
        }
    }

    private void endSale() {
        cashierGui.endSale();
    }

    private void startSale() {
        cashierGui.startSale();
    }

    private boolean textfieldIsNotEmpty(JTextField jTextField) {
        return !jTextField.getText().isEmpty();
    }

}
package view.cashierview.cashiergui.buttons;

import view.cashierview.io.IOHandler;

/**
 * Class that handles the push buttons in the cashier gui
 */
public class ButtonHandler {
    private InputButton startButton;
    private InputButton endSaleButton;
    private InputButton registerItemButton;
    private InputButton discountButton;
    private InputButton paymentButton;

    public ButtonHandler(){
        startButton = new CardSwitchingButton("Start sale");
        endSaleButton = new CardSwitchingButton("End sale");
        registerItemButton = new RegistrationButton("Register item");
        discountButton = new RegistrationButton("signalDiscount");
        paymentButton = new RegistrationButton("Enter payment");
    }


    public void addActionListeners(IOHandler ioHandler) {
        startButton.addActionListener(ioHandler::actionPerformed);
        registerItemButton.addActionListener(ioHandler::actionPerformed);
        endSaleButton.addActionListener(ioHandler::actionPerformed);
        discountButton.addActionListener(ioHandler::actionPerformed);
        paymentButton.addActionListener(ioHandler::actionPerformed);
    }

    public InputButton getStartButton() {
        return startButton;
    }

    public InputButton getDiscountButton() {
        return discountButton;
    }

    public InputButton getRegisterItemButton() {
        return registerItemButton;
    }

    public InputButton getPaymentButton() {
        return paymentButton;
    }

    public InputButton getEndSaleButton() {
        return endSaleButton;
    }


}

package view.cashierview.cashiergui.buttons;

import view.cashierview.cashiergui.InputHandler;

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


    public void addActionListeners(InputHandler inputHandler) {
        startButton.addActionListener(inputHandler::actionPerformed);
        registerItemButton.addActionListener(inputHandler::actionPerformed);
        endSaleButton.addActionListener(inputHandler::actionPerformed);
        discountButton.addActionListener(inputHandler::actionPerformed);
        paymentButton.addActionListener(inputHandler::actionPerformed);
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

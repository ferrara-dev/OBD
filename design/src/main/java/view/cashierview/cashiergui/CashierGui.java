package view.cashierview.cashiergui;

import view.cashierview.CashierView;
import view.cashierview.cashiergui.panels.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CashierGui extends JFrame implements ActionListener, ItemListener {
    static CashierView cashierView;
    DisplayPanel displayPanel;
    DisplayPanel secondDisplayPanel;
    JPanel cards;


    /**
     * Buttons used to send input to the controller
     */
    InputButton startButton;
    InputButton endSaleButton;
    InputButton registerItem;
    InputButton signalDiscount;
    InputButton enterPayment;
    private final InputButton[] buttons = new InputButton[]{startButton, endSaleButton, registerItem, signalDiscount, enterPayment};
    final JTextField itemIdTextField = new JTextField(10);
    final JTextField itemQuantityTextField = new JTextField(10);
    final JTextField customerIdTextField = new JTextField(10);
    final JTextField paymentTextField = new JTextField(10);

    final JTextArea endSaleTextArea = new JTextArea(10, 20);
    final JTextArea receiptTextArea = new JTextArea(10, 20);
    final JTextArea saleInformationArea = new JTextArea(10, 20);
    final JTextArea processedGoodsInformationArea = new JTextArea(10, 20);
    final JLabel customerIdLabel = new JLabel("Customer id :");
    final JLabel endSaleLabel = new JLabel("Total ");
    final JLabel receiptLabel = new JLabel("Receipt ");
    final JLabel itemIdLabel = new JLabel("Item id :");
    final JLabel saleInformationLabel = new JLabel("SaleInformation ");
    DefaultTableModel model;
    JTable jTable;
    public CashierGui(CashierView cashierView) throws Exception {
        this.cashierView = cashierView;
        model = new DefaultTableModel();

        jTable = new JTable(model);
        saleInformationArea.setEditable(false);
        startButton = new CardSwitchingButton("Start sale");
        endSaleButton = new CardSwitchingButton("End sale");
        registerItem = new RegistrationButton("Register item");
        signalDiscount = new RegistrationButton("signalDiscount");
        enterPayment = new RegistrationButton("Enter payment");
        displayPanel = new DisplayPanel();
        secondDisplayPanel = new DisplayPanel();
        cards = new JPanel(new CardLayout());
        GuiCreator guiCreator = new GuiCreator(this);
        addActionListeners();

    }

    private void initDisplayPanel() throws Exception {

        displayPanel = new DisplayPanel();
        //   displayPanel.addComponents("top, growx",saleInformationLabel);
        saleInformationArea.setEditable(false);

        displayPanel.addComponents("top,growx,push, wrap", saleInformationArea);
    }

    private void addActionListeners() {
        startButton.addActionListener(this::actionPerformed);
        registerItem.addActionListener(this::actionPerformed);
        endSaleButton.addActionListener(this::actionPerformed);
        signalDiscount.addActionListener(this::actionPerformed);
        enterPayment.addActionListener(this::actionPerformed);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerItem && textfieldIsNotEmpty(itemIdTextField)) {
            int itemId = Integer.parseInt(itemIdTextField.getText());
            int quantity;
            if (!textfieldIsNotEmpty(itemQuantityTextField))
                quantity = 1;
            else
                quantity = Integer.parseInt(itemQuantityTextField.getText());
            String displayMessage = (cashierView.registerItem(itemId, quantity));
            saleInformationArea.setText(displayMessage);
        }

        if (e.getSource() == enterPayment && textfieldIsNotEmpty(paymentTextField)) {
            String displayMessage = cashierView.enterPayment(Double.parseDouble(paymentTextField.getText()));
            endSaleTextArea.setText(displayMessage);
        }

        if (e.getSource() == signalDiscount && textfieldIsNotEmpty(customerIdTextField)) {
            String customerId = customerIdTextField.getText();
            String displayMessage = cashierView.signalDiscountRequest(cashierView.signalDiscountRequest(customerId));
            if (displayMessage == "Customer Id not found")
                infoBox(displayMessage);
            else
                endSaleTextArea.setText(displayMessage);
        }

        if (e.getSource() == endSaleButton) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.next(cards);
            String total = cashierView.endSale();
            endSaleTextArea.setText(total);
        }

        if (e.getSource() == startButton) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.next(cards);
            cashierView.startSale();
        }
    }

    public void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + "error ", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean textfieldIsNotEmpty(JTextField jTextField) {
        return !jTextField.getText().isEmpty();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}


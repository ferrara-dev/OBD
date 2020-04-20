package view.cashierview.cashiergui.panels;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.cashierview.cashiergui.panels.DisplayPanel;

/**
 * Class that handles containers for output text shown by the cashier gui
 */
public class TextHandler {
    private final JTextField itemIdTextField = new JTextField(10);
    private final JTextField itemQuantityTextField = new JTextField(10);
    private final JTextField customerIdTextField = new JTextField(10);
    private final JTextField paymentTextField = new JTextField(10);
    private final JTextArea endSaleTextArea = new JTextArea(10, 20);
    private final JTextArea saleInformationArea = new JTextArea(10, 20);

    public TextHandler(){
        saleInformationArea.setEditable(false);
        endSaleTextArea.setEditable(false);
    }

    /**
     * updates the text that the gui shows after the sale has been ended
     * @param update
     */
    public void setEndSaleTextArea(String update){
        endSaleTextArea.setText(update);
    }

    /**
     * updates the text that the gui shows during the sale
     * @param update
     */
    public void setSaleInformationArea(String update){
        saleInformationArea.setText(update);
    }

    public JTextField getItemIdTextField() {
        return itemIdTextField;
    }

    public JTextField getItemQuantityTextField() {
        return itemQuantityTextField;
    }

    public JTextField getCustomerIdTextField() {
        return customerIdTextField;
    }

    public JTextField getPaymentTextField() {
        return paymentTextField;
    }

    public JTextArea getEndSaleTextArea() {
        return endSaleTextArea;
    }

    public JTextArea getSaleInformationArea() {
        return saleInformationArea;
    }
}

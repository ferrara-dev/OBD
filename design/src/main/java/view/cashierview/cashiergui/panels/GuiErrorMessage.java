package view.cashierview.cashiergui.panels;

import util.NotFoundException;

import javax.swing.*;

public class GuiErrorMessage {

    public static void getErrorPopUp(String errorMessage){
       JOptionPane.showMessageDialog(null, errorMessage, "Error message",
                JOptionPane.ERROR_MESSAGE);
    }

}

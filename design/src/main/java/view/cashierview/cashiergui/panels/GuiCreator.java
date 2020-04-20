package view.cashierview.cashiergui.panels;

import view.cashierview.PropertyListenerFactory;
import view.cashierview.cashiergui.CashierGui;
import view.cashierview.cashiergui.ComponentAdder;

import javax.swing.*;
import java.awt.*;

public class GuiCreator {
    private final Dimension SCREEN_SIZE = new Dimension(800, 600);
    private JFrame mainFrame;
    private DisplayPanel displayPanel;
    private CashierGui cashierGui;
    private ComponentAdder componentAdder;
    PropertyListenerFactory propertyListenerFactory;
    public GuiCreator(CashierGui cashierGui) throws Exception {
        propertyListenerFactory = new PropertyListenerFactory(this);
        this.cashierGui = cashierGui;
        createGUI();
        showGUI();
        componentAdder = new ComponentAdder(this);
    }

    public PropertyListenerFactory getPropertyListenerFactory() {
        return propertyListenerFactory;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public CashierGui getCashierGui() {
        return cashierGui;
    }

    private void createGUI() throws Exception {
        mainFrame = new JFrame("Point of sale");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout());
    }

    private void showGUI() throws Exception {
        mainFrame.setPreferredSize(SCREEN_SIZE);
        mainFrame.setDefaultLookAndFeelDecorated(true);
        //cashierGui.addComponentToPane(mainFrame.getContentPane());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}

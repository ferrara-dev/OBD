package view.cashierview.cashiergui.panels.cards;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class StartSalePanel extends JPanel {
    private JButton startButton;

    public StartSalePanel(){
        setLayout(new MigLayout("fill"));
        startButton = new JButton("Start Sale");
        add(startButton,"center, grow, fill");
    }

    public JButton getStartButton(){
        return startButton;
    }
}

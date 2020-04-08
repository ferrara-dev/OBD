package view.cashierview;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    private JButton [] buttons;
    public ButtonPanel(JButton ... btns){
        buttons = btns;
        setLayout(new MigLayout("fill"));

        addButtons();

        setBorders();
    }

    private void addButtons(){
        for(JButton btn: buttons) {
            add(btn, "growx,wrap");
        }
    }

    private void setBorders(){
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                getBorder()));
    }
}

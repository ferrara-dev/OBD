package view.cashierview.cashiergui.panels;

import net.miginfocom.swing.MigLayout;
import view.cashierview.cashiergui.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private JPanel rootDisplayPanel;

    public DisplayPanel() throws Exception {
        setLayout(new MigLayout("wrap", "[fill, grow]", "[fill, grow][fill, grow]"));
        GuiUtil.setBorderCol(this, Color.RED);
        initInformationDisplay();
        add(rootDisplayPanel,"top");

    }

    public void addComponents(String constraint, JComponent jComponents){
        rootDisplayPanel.add(jComponents,constraint);
    }

    private void initInformationDisplay() throws Exception {
        rootDisplayPanel = new NestedDisplayPanel();

    }

    class NestedDisplayPanel extends JPanel {

        NestedDisplayPanel(){
            setLayout(new MigLayout("nogrid, flowy, debug"));
           // add(saleInformationLabel, "top");
           // add(saleInformationArea, "top, grow");
           // add(itemIdLabel, "top");
          //  add(itemIdTextField, "top, push");
        }
    }
}

package view.cashierview.cashiergui.panels;

import net.miginfocom.swing.MigLayout;
import view.cashierview.cashiergui.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private JPanel rootDisplayPanel;
    private final JLabel itemIdLabel = new JLabel("Item id :");
    private final JLabel saleInformationLabel = new JLabel("SaleInformation ");

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

    private JPanel initRootPanels() {
        JPanel panel = new JPanel(new MigLayout("nogrid, flowy, debug"));
        panel.add(new JScrollPane(new JTextArea(5, 20)));
        return panel;
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

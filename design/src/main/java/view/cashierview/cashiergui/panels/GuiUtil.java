package view.cashierview.cashiergui.panels;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GuiUtil {
    public static final GridBagLayout GRID_BAG_LAYOUT = new GridBagLayout();
    public static final GridBagConstraints gbc = new GridBagConstraints();
    public final static String PAGE1_DESCRIPTION = "page1 description";

    public GuiUtil() throws IOException, URISyntaxException {

    }

    public static void layoutComponents(int x, int y, int width, int height,
                                        JComponent addThis, JComponent addTo) {

        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addTo.add(addThis, gbc);
    }

    public static void setBorderCol(JComponent component, Color color){
        component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color),
                component.getBorder()));
    }


}

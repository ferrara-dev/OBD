package view.guiutil;


import controller.ControllerFactory;
import startup.LayerCreator;
import view.gui.CashierGui;
import view.gui.MainFrame;
import view.gui.ViewHandler;

import java.awt.*;

public class GuiCreator {
    private final Dimension SCREEN_SIZE = new Dimension(800, 600);
    private MainFrame mainFrame;
    private ViewFactory viewFactory;


    public GuiCreator(LayerCreator layerCreator) throws Exception {
        viewFactory = new ViewFactory(layerCreator.getControllerFactory());
        createGUI();
        showGUI();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }


    private void createGUI() throws Exception {
        mainFrame = new MainFrame();
        mainFrame.initDefault();
        mainFrame.add(viewFactory.getViewHandler());
    }

    private void showGUI() throws Exception {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}

package view.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame  {
    private final String TITLE = "Point of Sale";
    private final Dimension SCREEN_SIZE = new Dimension(800, 600);


    public MainFrame(String title){
        super(title);
    }

    public MainFrame(){

    }

    public void initDefault(){
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        setPreferredSize(SCREEN_SIZE);
        setDefaultLookAndFeelDecorated(true);
    }


    @Override
    public void add(Component comp, Object constraints) {
        super.add(comp, constraints);
    }

}

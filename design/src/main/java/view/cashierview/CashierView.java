package view.cashierview;

import startup.LayerCreator;
import startup.Main;
import view.View;
import view.cashierview.cashiergui.CashierGui;
import view.cashierview.io.BeanTableModel;
import java.beans.PropertyChangeEvent;


public class CashierView extends View {

    private LayerCreator creator;
    private CashierGui cashierGui;
    private BeanTableModel beanTableModel;

    public CashierView(BeanTableModel tableModel) throws Exception {
        this.beanTableModel = tableModel;
        this.creator = Main.getLayerCreator();
        this.cashierGui = Main.getCashierGUI();
    }

    public static final String SALE_ITEM_QUANTITY = "Quantity";
    public static final String SALE_ITEM_TOTALPRICE = "Font";
    public static final String ELEMENT_X_PROPERTY = "X";
    public static final String ELEMENT_Y_PROPERTY = "Y";
    public static final String ELEMENT_OPACITY_PROPERTY = "Opacity";
    public static final String ELEMENT_ROTATION_PROPERTY = "Rotation";

    //  Code omitted
    // This method is called every time the property value is changed
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Name = " + evt.getPropertyName());

        System.out.println("Old Value = " + evt.getOldValue());

        System.out.println("New Value = " + evt.getNewValue());

        System.out.println("**********************************");
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        {
            if (evt.getPropertyName().equals(
                    "quantity")) {
                String newStringValue = evt.getNewValue().toString();
               beanTableModel.setValueAt(evt.getNewValue(),2,1);
            }
           /*
            } else if
            (evt.getPropertyName().equals(
                            DefaultController.ELEMENT_Y_PROPERTY)) {
                String newStringValue = evt.getNewValue().toString();
                yPositionTextField.setText(newStringValue);
            } else if
            (evt.getPropertyName().equals(
                            DefaultController.ELEMENT_OPACITY_PROPERTY)) {
                int newIntegerValue = (Integer)evt.getNewValue();
                opacitySpinner.setValue(newIntegerValue);
                opacitySlider.setValue(newIntegerValue);
            } else if
            (evt.getPropertyName().equals(
                            DefaultController.ELEMENT_ROTATION_PROPERTY)) {
                int newIntegerValue = (Integer)evt.getNewValue();
                rotationSpinner.setValue(newIntegerValue);
                rotationSlider.setValue(newIntegerValue);
            } else if
            (evt.getPropertyName().equals(
                            DefaultController.ELEMENT_TEXT_PROPERTY)) {
                String newStringValue = evt.getNewValue().toString();
                text.setText(newStringValue);
            } else if
            (evt.getPropertyName().equals(
                            DefaultController.ELEMENT_FONT_PROPERTY)) {
                Font f = (Font)evt.getNewValue();
                String fontString = f.getFontName() + " " + f.getSize();
                font.setText(fontString);
                currentFont = f;
            }
            */


        }
    }
}
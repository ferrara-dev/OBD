package view;

import model.AbstractModel;
import model.listener.saleprocess.SaleProgressListener;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class View extends JPanel implements PropertyChangeListener, SaleProgressListener {
    private ArrayList<AbstractModel> registeredModels;
    private ArrayList<View> registeredViews;

    public View() {
        registeredViews = new ArrayList<View>();
        registeredModels = new ArrayList<AbstractModel>();
    }

    public abstract Object getSaleView();

    public void addModel(AbstractModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    //  Use this to observe property changes from registered models
    //  and propagate them on to all the views.
    public void propertyChange(PropertyChangeEvent evt) {
        for (AbstractModel model: registeredModels) {
            modelPropertyChange(evt);
        }
    }

   abstract public void modelPropertyChange(final PropertyChangeEvent evt);

        //  Remainder of the code omitted


    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName = The name of the property.
     * @param newValue = An object that represents the new value
     * of the property.
     */
    protected void setModelProperty(String propertyName, Object newValue) {

        for (AbstractModel model: registeredModels) {
            try {

                Method method = model.getClass().
                        getMethod("set"+propertyName, new Class[] {
                                        newValue.getClass()
                                }


                        );
                method.invoke(model, newValue);

            } catch (Exception ex) {
                //  Handle exception.
            }
        }
    }
}

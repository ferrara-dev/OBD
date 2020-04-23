package model.sale;

import model.AbstractModel;
import model.listener.saleprocess.SaleProgressListener;
import util.Calendar;

import java.util.ArrayList;

public class SaleDetail extends AbstractModel {
    ArrayList<SaleProgressListener> saleProgressListeners;
    private boolean active;
    private boolean completed;
    private String timeAndDateOfSale;
    private SaleId id;

    /**
     * Creates a new instance representing details about
     * a specific transaction.
     */
    public SaleDetail() {

    }

    public void addSaleProgressListener(SaleProgressListener saleProgressListener){
        if(saleProgressListeners == null)
            saleProgressListeners = new ArrayList();
        saleProgressListeners.add(saleProgressListener);
    }
    public void createDefault() {
        setSaleId(new SaleId());
        setCompleted(false);
        setActive(true);
        setTimeAndDateOfSale(Calendar.getTimeAndDate());
    }

    public SaleId getSaleId(){
        return id;
    }

    public void setSaleId(SaleId id) {
        this.id = id;
    }

    public SaleId getId() {
        return id;
    }

    public void setId(SaleId id) {
        this.id = id;
    }

    public String getTimeAndDateOfSale() {
        return this.timeAndDateOfSale;
    }

    private void setTimeAndDateOfSale(String timeAndDateOfSale) {
        this.timeAndDateOfSale = timeAndDateOfSale;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        firePropertyChange("active",this.active,active);
        this.active = active;
        if(active == true){
            saleProgressListeners.get(0).SaleHasStarted(active);
        }
        else
            saleProgressListeners.get(0).SaleIsPayed(active);
    }

    public boolean isCompleted() {
        return completed;
    }

    public String asText() {
        StringBuilder sb = new StringBuilder();

        return "sb.toString()";
    }

    public void setCompleted(boolean completed) {
        firePropertyChange("completed",this.completed,completed);
        this.completed = completed;
        saleProgressListeners.get(0).SaleHasEnded(completed);
    }

}

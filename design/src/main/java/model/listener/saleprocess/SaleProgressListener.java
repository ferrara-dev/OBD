package model.listener.saleprocess;

import model.listener.ModelListener;

public interface SaleProgressListener extends ModelListener {
    void SaleHasStarted(boolean active);
    void SaleHasEnded(boolean completed);
    void SaleIsPayed(boolean active);
}

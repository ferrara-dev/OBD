package view.cashierview.cashiergui.JList;

import java.util.List;
import javax.swing.AbstractListModel;

public class CustomListModel<E> extends AbstractListModel <E> {
    protected List <E> list;


    public CustomListModel(List <E> list) {
        this.list = list;

    }

    public CustomListModel() {
    }
    public void addElement(E element) {
        list.add(element);
        int index = list.size();
        fireContentsChanged(element,index,index);
    }

    public void fireDateChanged() {
        int index = list.size();
        fireContentsChanged(list.get(index-1), index,index);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public E getElementAt(int index) {
        return list.get(index);
    }

    public void removeElement(E element) {
        list.remove(element);
        int index = list.size();
        fireContentsChanged(element,index,index);
    }



}

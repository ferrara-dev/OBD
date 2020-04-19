package view.cashierview.cashiergui.JList;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;


public abstract class ProductJList<Obj> extends JList {
    private List<Obj> objects;
    CustomListModel<String> listModel;

    public ProductJList(Obj object) throws Exception {
        initList(object);
        List<String> productNames = new ArrayList<>();
        CustomListModel<String> listModel = new CustomListModel<String>(productNames);
        setModel(listModel);
    }

    abstract void initList(Obj object) throws Exception;

    abstract public List<Obj> getProducts();

    abstract public void searchFilter(String searchTerm);

    /*
    {
        CustomListModel filteredItems = new CustomListModel();


        objects.forEach((product) -> {
            String productName = product.getName().toLowerCase();
            if (productName.contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(product);
            }
        });
        listModel = filteredItems;
        this.setModel(listModel);

    }

     */

}



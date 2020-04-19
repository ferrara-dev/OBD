package view.cashierview.io;
import com.jidesoft.list.QuickListFilterField;
import view.cashierview.cashiergui.JList.CustomListModel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public abstract class Interpreter <Model>{
    private List<Model> modelList;
    private CustomListModel<String> listModel;
    private QuickListFilterField filterField;
    private JList Jlist;

    public Interpreter(Model... model){
        modelList = Arrays.asList(model);
    }

}

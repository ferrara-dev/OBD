package view.cashierview.cashiergui.buttons;

import integration.DataBaseHandler;
import integration.productdb.InventoryHandler;
import integration.datatransferobject.ItemDTO;
import model.AbstractModel;
import model.itemmodel.Product;
import model.salemodel.SaleItem;
import view.cashierview.io.BeanTableModel;
import view.cashierview.io.RowTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class JButtonTableModel extends RowTableModel<JButton>
{
    private static String[] COLUMN_NAMES =
            {
                    "Text",
                    "Tool Tip Text",
                    "Enabled",
                    "Visible"
            };

    JButtonTableModel()
    {
        super( Arrays.asList(COLUMN_NAMES) );
        setRowClass( JButton.class );

        setColumnClass(2, Boolean.class);
        setColumnClass(3, Boolean.class);
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        JButton button = getRow(row);

        switch (column)
        {
            case 0: return button.getText();
            case 1: return button.getToolTipText();
            case 2: return button.isEnabled();
            case 3: return button.isVisible();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column)
    {
        JButton button = getRow(row);

        switch (column)
        {
            case 0: button.setText((String)value); break;
            case 1: button.setToolTipText((String)value); break;
            case 2: button.setEnabled((Boolean)value); break;
            case 3: button.setVisible((Boolean)value); break;
        }

        fireTableCellUpdated(row, column);
    }

    public static void main(String[] args)
    {
        DataBaseHandler<ItemDTO,Integer> handler = new InventoryHandler();

        Product one = new Product();
        one.createItemModel(handler.collect("1"));
        Product two = new Product();
        two.createItemModel(handler.collect("2"));
        Product three = new Product();
        three.createItemModel(handler.collect("2"));
        SaleItem s1 = new SaleItem(one);
        SaleItem s2 = new SaleItem(two);
    //    InputButton one = new CardSwitchingButton("One");
     //   InputButton two = new RegistrationButton("Two");
     //   InputButton three = new RegistrationButton("Three");

        //  Use the custom model

        //JButtonTableModel model = new JButtonTableModel();

        //  Use the BeanTableModel

		BeanTableModel<AbstractModel> model =
		new BeanTableModel<AbstractModel>(Product.class);

        model.addRow(s1);
        model.addRow(s2);

        model.setColumnEditable(1,false);
        JTable table = new JTable(model);
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        JScrollPane scrollPane = new JScrollPane( table );

        JPanel south = new JPanel();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( scrollPane );
        frame.getContentPane().add( south, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);



    }
}
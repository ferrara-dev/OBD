package startup;


import com.alee.laf.WebLookAndFeel;
import com.alee.skin.dark.WebDarkSkin;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.h2.tools.RunScript;
import view.cashierview.CashierView;
import view.cashierview.cashiergui.CashierGui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;


public class Main {
    private static CashierGui cashierGUI;
    private static LayerCreator layerCreator;
    public static void main(String[] args) throws Exception {
        DBCreator.createTable();
        start();
    }

    public static LayerCreator getLayerCreator() {
        return layerCreator;
    }

    public static CashierGui getCashierGUI() {
        return cashierGUI;
    }

    private static void start() throws Exception {

        layerCreator = new LayerCreator();
        run(layerCreator);
    }

    private static void run(LayerCreator layerCreator) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    WebLookAndFeel.install ( WebDarkSkin.class );
                    cashierGUI =  new CashierGui(layerCreator);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private static class DBCreator {
        private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
        public static void createTable() {
            InputStream inputStream = null;
            Reader targetReader = null;
            // Step 1: Establishing a Connection
            try (Connection connection = DriverManager.getConnection(URL)) {
               inputStream = Main.class.getResourceAsStream("/db.sql");
               targetReader = new InputStreamReader(inputStream);
                // run script file with H2 RunScript
                RunScript.execute(connection, targetReader);
            } catch (JdbcSQLIntegrityConstraintViolationException ei) {
               System.out.println("Data already created!");
            } catch (SQLException e) {
                printSQLException(e);
                System.exit(-1);
            } finally {
                try {
                    if(Objects.nonNull(inputStream)) {
                        inputStream.close();
                    }
                    if(Objects.nonNull(targetReader)) {
                        targetReader.close();
                    }
                } catch (Exception e) {
                    System.exit(-1);
                }
            }
        }

        public static void printSQLException(SQLException ex) {

            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("Error Code: " + ex.getErrorCode());
            System.err.println("Message: " + ex.getMessage());
            Throwable t = ex.getCause();
            System.out.println("Cause: " + t);
        }


    }


}




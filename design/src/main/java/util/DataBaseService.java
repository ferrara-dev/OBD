package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseService {
    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    public static final String SQL_FIND_CUSTOMER_BY_ID = "SELECT * FROM CustomerDB WHERE id='%s';";
    public static final String SQL_CUSTOMER_TABLE_NAME = "CustomerDB";
    private static final String SQL_DELETE_CUSTOMER = "DELETE FROM customers WHERE id='%s';";

    public static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM ProductDB WHERE id='%s';";
    public static final String SQL_PRODUCT_TABLE_NAME = "ProductDB";

    public static boolean find(final String SQL_STATEMENT , String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SQL_STATEMENT, id));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }
    public static boolean read(final String SQL_STATEMENT , String id) {

        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SQL_STATEMENT, id));

            while(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    public boolean delete(final String SQL_STATEMENT, String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(String.format(SQL_STATEMENT,id));
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    public boolean register(final String SQL_STATEMENT, String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            int rs = stm.executeUpdate(String.format(SQL_STATEMENT,id));
            return rs>0;
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JavaSeH2Memory.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

}

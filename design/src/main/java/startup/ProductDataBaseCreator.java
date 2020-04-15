package startup;

import java.sql.*;

public class ProductDataBaseCreator {
    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String createTestTableSQL = "create table IF NOT EXISTS ProductDB(\r\n" + "  id  varchar(20) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  category varchar(20),\r\n" + "  stockstatus varchar(20),\r\n" +
            "  price varchar(20)\r\n" + "  );";

    private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO  ProductDB " +
            "VALUES ('2', 'blueberries', 'samuel@gmail.com', 'India', '123')," +
            "('3', 'blåbär', 'deepa@gmail.com', 'India', '123')," + "('4', 'saft', 'top@gmail.com', 'India', '123');";

    private static final String SQL_FIND_USER = "SELECT * FROM CustomerDB WHERE id='%s';";

    public static void createTable() throws SQLException {
        System.out.println(createTestTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager
                .getConnection(URL);

             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTestTableSQL);
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
    public static boolean find(String itemID) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SQL_FIND_USER, itemID));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }


    public static void insertRecord() throws SQLException {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager
                .getConnection(URL);

             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
            System.out.println("No. of records affected : " + result);
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void readRecord(String tableName, String item,String key) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();

            System.out.println("Reading data from " + tableName);
            stm = con.createStatement();
            String sql = "SELECT " + item + " FROM " + tableName + " WHERE id='%s'";
            ResultSet rs = stm.executeQuery(String.format(sql,key));

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                // Display values
                System.out.print("User : " + name);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

package integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String INSERT_TEMPLATE = "INSERT INTO  %s VALUES (%s, %s);";
    private static final ObjectMapper objectMapper = new ObjectMapper();;

    public static void logSale(String table, String id, Object obj) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();
            String value = objectMapper.writeValueAsString(obj);
            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(String.format(INSERT_TEMPLATE,table,id, value));
            System.out.println("No. of records affected : " + result);
        } catch (JsonProcessingException jme) {
            System.err.println(jme.getMessage());
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
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

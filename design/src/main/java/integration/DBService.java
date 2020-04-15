package integration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.salemodel.SaleDetail;
import util.NotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class DBService {

    private static final String URL = "jdbc:h2:file:./userDB;DB_CLOSE_DELAY=-1";
    private static final String INSERT_TEMPLATE = "INSERT INTO  %s VALUES ('%s', '%s' FORMAT JSON);";
    private static final String SELECT_TEMPLATE = "SELECT * FROM %s WHERE id='%s';";
    //UPDATE table_name
    //SET column1 = value1, column2 = value2, ...
    //WHERE condition;
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET status=%s WHERE id='%s';";
    private static final ObjectMapper objectMapper = new ObjectMapper();;

    public static void logSale(String id, Object obj) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();
            String value = Base64.getEncoder().encodeToString(objectMapper.writeValueAsString(obj).getBytes());
            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(String.format(INSERT_TEMPLATE,"sales",id, objectMapper.writeValueAsString(obj)));
            System.out.println("No. of records affected : " + result);
        } catch (JsonProcessingException jme) {
            System.err.println(jme.getMessage());
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
    }
    public static SaleDetail getSale(String id) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet result = statement.executeQuery(String.format(SELECT_TEMPLATE,"sales",id));
            while (result.next()) {
                Reader reader = result.getClob(2).getCharacterStream();
                StringBuilder buffer = new StringBuilder();
                int numCharsRead;
                char[] arr = new char[8 * 1024];
                while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
                    buffer.append(arr, 0, numCharsRead);
                }
                reader.close();
                String targetString = buffer.toString();
                return objectMapper.readValue(targetString,SaleDetail.class);
            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw  new NotFoundException("SaleDetail not found!");
    }

    public static ItemDetail getProduct(int id) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet result = statement.executeQuery(String.format(SELECT_TEMPLATE,"products",id));
            while (result.next()) {
                /**
                 * `name` VARCHAR(MAX) NULL,
                 * `amount` FLOAT NULL,
                 * `unit` VARCHAR(MAX) NULL,
                 * `price` INT NULL,
                 * `category` VARCHAR(MAX) NULL,
                 * `id` INT primary key,
                 * `status` INT NULL
                 */

                String name = result.getString("name");
                float amount = result.getFloat("amount");
                String unit = result.getString("unit");
                int price = result.getInt("price");
                String category = result.getString("category");
                int itemId = result.getInt("id");
                int status = result.getInt("status");
                ItemDetail detail = new ItemDetail(name,price,category,itemId,status);
                return detail;
            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
        throw  new NotFoundException("SaleDetail not found!");
    }

    public static int updateProduct(int id, int status) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(String.format(UPDATE_TEMPLATE,"products",status,id));
            return result;

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }
        throw  new NotFoundException("SaleDetail not found!");
    }

    public static void printSQLException(SQLException ex) {

        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        System.out.println("Cause: " + t);
    }
}

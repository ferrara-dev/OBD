package integration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.datatransferobject.DiscountDTO;
import integration.datatransferobject.ItemDTO;
import java.util.ArrayList;
import java.util.List;

import model.sale.Sale;
import util.Calendar;
import util.NotFoundException;

import java.io.IOException;
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
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET stockstatus=%s WHERE id='%s';";

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

    public static Sale getSale(String id) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            ResultSet result = statement.executeQuery(String.format(SELECT_TEMPLATE,"sales", id));
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

                return objectMapper.readValue(targetString, Sale.class);
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
        throw  new NotFoundException("Sale not found!");
    }


    public static boolean find(String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SELECT_TEMPLATE,"ProductDB",id));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }

    private static final String SELECT_DISCOUNT_TEMPLATE = "SELECT * FROM %s ;";

    public static List<DiscountDTO> getDiscount(){

        try (Connection con = DriverManager.getConnection(URL)){
            List<DiscountDTO> discountDTOList = new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SELECT_DISCOUNT_TEMPLATE,"discountDB"));

            while(rs.next()) {
                String available = rs.getString("available");
                String[] dates = available.split(":");
                boolean isAvailable = false;

                for(String date: dates){
                    if(date.equals(Calendar.getDayOfTheWeek().name())){
                        isAvailable = true;
                        break;
                    }
                }

                if(isAvailable) {
                    String itemId = rs.getString("id");
                    String type = rs.getString("type");
                    String requirement = rs.getString("requierment");
                    String reduction = rs.getString("reduction");
                    String limit = rs.getString("limitation");
                    DiscountDTO discountDTO = new DiscountDTO(type, requirement,reduction,limit,itemId);
                    discountDTOList.add(discountDTO);
                }

                else
                    continue;
            }

            return discountDTOList;
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        throw new NotFoundException("Item not found");
    }


    public static ItemDTO getProduct(String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SELECT_TEMPLATE,"ProductDB",id));

            while(rs.next()) {
                int itemId = Integer.parseInt(rs.getString("id"));
                int stockStatus = Integer.parseInt(rs.getString("stockstatus"));
                double price = Double.parseDouble(rs.getString("price"));
                String name = rs.getString("name");
                String category = rs.getString("category");
                ItemDTO itemDTO = new ItemDTO(name,price,category,itemId,stockStatus);
                return itemDTO;

            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        throw new NotFoundException("Item not found");
    }


    public static int updateProduct(int id, int stockstatus) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(String.format(UPDATE_TEMPLATE,"ProductDB",stockstatus, id));
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

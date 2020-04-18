package integration.productdb;

import integration.DataBaseHandler;
import util.NotFoundException;

import java.sql.*;

public class InventoryHandler implements DataBaseHandler <ItemDTO,Integer> {
    /**
     * Override to register
     * @param id
     * @param stockstatus
     * @return
     */
    @Override
    public boolean register(String id, Integer stockstatus) {
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();

            // Step 3: Execute the query or update query
            int result = statement.executeUpdate(String.format(UPDATE_TEMPLATE,"ProductDB",stockstatus, id));
            return true;

        } catch (SQLException e) {

            // print SQL exception information
            DataBaseHandler.printSQLException(e);
        }
        throw  new NotFoundException("SaleDetail not found!");
    }

    @Override
    public boolean find(String id) {
        try (Connection con = DriverManager.getConnection(URL)){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(String.format(SELECT_TEMPLATE,"ProductDB",id));

            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DataBaseHandler.printSQLException(ex);
        }
        return false;
    }

    @Override
    public ItemDTO collect(String id) {
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
            DataBaseHandler.printSQLException(ex);
        }

        throw new NotFoundException("Item not found");
    }
}

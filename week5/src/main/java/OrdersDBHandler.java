import java.sql.*;
import java.time.LocalDate;

public class OrdersDBHandler extends  Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectOrders() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_ORDERS.s);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                long orderId = rs.getLong("order_id");
                long clientId = rs.getLong("client_id");
                long carId = rs.getLong("car_id");
                Date placementDate = rs.getDate("placement_date");
                String orderNumber = rs.getString("order_number");
                String documentType = rs.getString("document_type");
                String documentNumber = rs.getString("document_number");
                String address = rs.getString("address");
                long saleDescriptionId = rs.getLong("sale_description_id");

                System.out.println("Order #" + orderId + " - " + clientId + " - " + carId + " - " +
                        placementDate + " - " + orderNumber + " - " + documentType + " - " + documentNumber + " - " + address + " - " + saleDescriptionId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(long clientId,
                            long carId,
                            LocalDate placementDate,
                            String orderNumber,
                            String documentType,
                            String documentNumber,
                            String address,
                            long saleDescriptionId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_ORDER.s)) {
            ps.setLong(1, clientId);
            ps.setLong(2, carId);
            ps.setDate(3, Date.valueOf(placementDate));
            ps.setString(4, orderNumber);
            ps.setString(5, documentType);
            ps.setString(6, documentNumber);
            ps.setString(7, address);
            ps.setLong(8, saleDescriptionId);

            ps.executeUpdate();
            System.out.println("The order inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(long orderId,
                            long clientId,
                            long carId,
                            LocalDate placementDate,
                            String orderNumber,
                            String documentType,
                            String documentNumber,
                            String address,
                            long saleDescriptionId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_ORDER.s)) {
            ps.setLong(1, clientId);
            ps.setLong(2, carId);
            ps.setDate(3, Date.valueOf(placementDate));
            ps.setString(4, orderNumber);
            ps.setString(5, documentType);
            ps.setString(6, documentNumber);
            ps.setString(7, address);
            ps.setLong(8, saleDescriptionId);
            ps.setLong(9, orderId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing order was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(long orderId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_ORDER.s)) {
            ps.setLong(1, orderId);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A order was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

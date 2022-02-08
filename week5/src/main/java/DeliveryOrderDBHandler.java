import java.sql.*;
import java.time.LocalDate;

public class DeliveryOrderDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectDeliveryOrders() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_DELIVERY_ORDERS.s);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                long id = rs.getLong("delivery_order_id");
                String orderDescription = rs.getString("order_description");
                long providerId = rs.getLong("provider_id");
                long staffId = rs.getLong("staff_id");
                Date placementDate = rs.getDate("placement_date");
                Date executionDate = rs.getDate("execution_date");
                long purchaseDescriptionId = rs.getLong("purchase_description_id");

                System.out.println("Delivery order #" + id + " - " + orderDescription + " - " + providerId + " - " +
                        staffId + " - " + placementDate + " - " + executionDate + " - " + purchaseDescriptionId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDeliveryOrder(String orderDescription,
                                    long providerId,
                                    long staffId,
                                    LocalDate placementDate,
                                    LocalDate executionDate,
                                    long purchaseDescriptionId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_DELIVERY_ORDER.s)) {
            ps.setString(1, orderDescription);
            ps.setLong(2, providerId);
            ps.setLong(3, staffId);
            ps.setDate(4, Date.valueOf(placementDate));
            ps.setDate(5, Date.valueOf(executionDate));
            ps.setLong(6, purchaseDescriptionId);

            ps.executeUpdate();
            System.out.println("The delivery order inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryOrder(long id,
                                    String orderDescription,
                                    long providerId,
                                    long staffId,
                                    LocalDate placementDate,
                                    LocalDate executionDate,
                                    long purchaseDescriptionId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_DELIVERY_ORDER.s)) {
            ps.setString(1, orderDescription);
            ps.setLong(2, providerId);
            ps.setLong(3, staffId);
            ps.setDate(4, Date.valueOf(placementDate));
            ps.setDate(5, Date.valueOf(executionDate));
            ps.setLong(6, purchaseDescriptionId);
            ps.setLong(7, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing delivery order was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeliveryOrder(long id) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_DELIVERY_ORDER.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A delivery order was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

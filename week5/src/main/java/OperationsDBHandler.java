import java.sql.*;
import java.time.LocalDate;

public class OperationsDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectOperations() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_OPERATIONS.s);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                long id = rs.getLong("operation_id");
                Date operationDate = rs.getDate("operation_date");
                long carId = rs.getLong("car_id");
                long deliveryOrderId = rs.getLong("delivery_order_id");
                String operationDescription = rs.getString("operation_description");
                double factoryPrice = rs.getDouble("factory_price");
                double costUpTo = rs.getDouble("cost_up_to");
                double totalAmount = rs.getDouble("total_amount");

                System.out.println("Operation #" + id + " - " + operationDate + " - " + carId + " - " +
                        deliveryOrderId + " - " + operationDescription + " - " + factoryPrice + " - " + costUpTo + " - " + totalAmount);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertOperation(LocalDate operationDate,
                                long carId,
                                long deliveryOrderId,
                                String operationDescription,
                                double factoryPrice,
                                double costUpTo,
                                double totalAmount) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_OPERATION.s)) {
            ps.setDate(1, Date.valueOf(operationDate));
            ps.setLong(2, carId);
            ps.setLong(3, deliveryOrderId);
            ps.setString(4, operationDescription);
            ps.setDouble(5, factoryPrice);
            ps.setDouble(6, costUpTo);
            ps.setDouble(7, totalAmount);

            ps.executeUpdate();
            System.out.println("The operation inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateOperation(long operationId,
                                LocalDate operationDate,
                                long carId,
                                long deliveryOrderId,
                                String operationDescription,
                                double factoryPrice,
                                double costUpTo,
                                double totalAmount) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_OPERATION.s)) {
            ps.setDate(1, Date.valueOf(operationDate));
            ps.setLong(2, carId);
            ps.setLong(3, deliveryOrderId);
            ps.setString(4, operationDescription);
            ps.setDouble(5, factoryPrice);
            ps.setDouble(6, costUpTo);
            ps.setDouble(7, totalAmount);
            ps.setLong(8, operationId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing operation was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteOperation(long operationId) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_OPERATION.s)) {
            ps.setLong(1, operationId);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A operation was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

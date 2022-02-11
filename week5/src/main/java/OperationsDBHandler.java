import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationsDBHandler implements DAO<Operation, Long> {
    private static Connection connection = null;

    @Override
    public List<Operation> getAll() {
        String selectAllOperations = "SELECT * FROM operations";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllOperations);
            rs = ps.executeQuery();
            List<Operation> operations = new ArrayList<Operation>();
            while(rs.next()) {
                Operation operation = new Operation();
                operation.setOperationId(rs.getLong("operation_id"));
                operation.setOperationDate(rs.getDate("operation_date"));
                operation.setCarId(rs.getLong("car_id"));
                operation.setDeliveryOrderId(rs.getLong("delivery_order_id"));
                operation.setOperationDescription(rs.getString("operation_description"));
                operation.setFactoryPrice(rs.getDouble("factory_price"));
                operation.setCostUpTo(rs.getDouble("cost_up_to"));
                operation.setTotalAmount(rs.getDouble("total_amount"));
                operations.add(operation);
            }
            return operations;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Operation getById(Long id) {
        String selectOperationById = "SELECT * FROM operations WHERE operation_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectOperationById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            boolean check = false;
            Operation operation = new Operation();
            while(rs.next()) {
                check = true;
                operation.setOperationId(rs.getLong("operation_id"));
                operation.setOperationDate(rs.getDate("operation_date"));
                operation.setCarId(rs.getLong("car_id"));
                operation.setDeliveryOrderId(rs.getLong("delivery_order_id"));
                operation.setOperationDescription(rs.getString("operation_description"));
                operation.setFactoryPrice(rs.getDouble("factory_price"));
                operation.setCostUpTo(rs.getDouble("cost_up_to"));
                operation.setTotalAmount(rs.getDouble("total_amount"));
            }
            if(check) {
                return operation;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Operation operation) {
        String insertOperation = "INSERT INTO operations (operation_date, car_id, delivery_order_id, operation_description, factory_price, cost_up_to, total_amount) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertOperation);
            ps.setDate(1, (Date) operation.getOperationDate());
            ps.setLong(2, operation.getCarId());
            ps.setLong(3, operation.getDeliveryOrderId());
            ps.setString(4, operation.getOperationDescription());
            ps.setDouble(5, operation.getFactoryPrice());
            ps.setDouble(6, operation.getCostUpTo());
            ps.setDouble(7, operation.getTotalAmount());

            ps.executeUpdate();
            System.out.println("The operation inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void update(Operation operation) {
        String updateOperation = "UPDATE operations SET operation_date=?, car_id=?, delivery_order_id=?, operation_description=?, factory_price=?, cost_up_to=?, total_amount=? WHERE operation_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateOperation);
            ps.setDate(1, (Date) operation.getOperationDate());
            ps.setLong(2, operation.getCarId());
            ps.setLong(3, operation.getDeliveryOrderId());
            ps.setString(4, operation.getOperationDescription());
            ps.setDouble(5, operation.getFactoryPrice());
            ps.setDouble(6, operation.getCostUpTo());
            ps.setDouble(7, operation.getTotalAmount());
            ps.setLong(8, operation.getOperationId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing operation was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        String deleteOperation = "DELETE FROM operations WHERE operation_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteOperation);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An operation was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}

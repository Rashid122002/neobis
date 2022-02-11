import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderDBHandler implements DAO<DeliveryOrder, Long> {
    private static Connection connection = null;

    @Override
    public List<DeliveryOrder> getAll() {
        String selectAllDeliveryOrders = "SELECT * FROM delivery_orders";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllDeliveryOrders);
            rs = ps.executeQuery();
            List<DeliveryOrder> deliveryOrders = new ArrayList<DeliveryOrder>();
            while(rs.next()) {
                DeliveryOrder deliveryOrder = new DeliveryOrder();
                deliveryOrder.setId(rs.getLong("delivery_order_id"));
                deliveryOrder.setOrderDescription(rs.getString("order_description"));
                deliveryOrder.setProviderId(rs.getLong("provider_id"));
                deliveryOrder.setStaffId(rs.getLong("staff_id"));
                deliveryOrder.setPlacementDate(rs.getDate("placement_date"));
                deliveryOrder.setExecutionDate(rs.getDate("execution_date"));
                deliveryOrder.setPurchaseId(rs.getInt("purchase_description_id"));
                deliveryOrders.add(deliveryOrder);
            }
            return deliveryOrders;
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
    public DeliveryOrder getById(Long id) {
        String selectAllDeliveryOrders = "SELECT * FROM delivery_orders WHERE delivery_order_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllDeliveryOrders);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            boolean check = false;
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            while(rs.next()) {
                check = true;
                deliveryOrder.setId(rs.getLong("delivery_order_id"));
                deliveryOrder.setOrderDescription(rs.getString("order_description"));
                deliveryOrder.setProviderId(rs.getLong("provider_id"));
                deliveryOrder.setStaffId(rs.getLong("staff_id"));
                deliveryOrder.setPlacementDate(rs.getDate("placement_date"));
                deliveryOrder.setExecutionDate(rs.getDate("execution_date"));
                deliveryOrder.setPurchaseId(rs.getInt("purchase_description_id"));
            }
            if(check) {
                return deliveryOrder;
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
    public void add(DeliveryOrder deliveryOrder) {
        String insertDeliveryOrder = "INSERT INTO delivery_orders (order_description, provider_id, staff_id, placement_date, execution_date, purchase_description_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertDeliveryOrder);
            ps.setString(1, deliveryOrder.getOrderDescription());
            ps.setLong(2, deliveryOrder.getProviderId());
            ps.setLong(3, deliveryOrder.getStaffId());
            ps.setDate(4, (Date) deliveryOrder.getPlacementDate());
            ps.setDate(5, (Date) deliveryOrder.getExecutionDate());
            ps.setLong(6, deliveryOrder.getPurchaseId());
            ps.executeUpdate();
            System.out.println("The delivery order inserted successfully!");
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
    public void update(DeliveryOrder deliveryOrder) {
        String updateDeliveryOrder = "UPDATE delivery_orders SET order_description=?, provider_id=?, staff_id=?, placement_date=?, execution_date=?, purchase_description_id=? WHERE delivery_order_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateDeliveryOrder);
            ps.setString(1, deliveryOrder.getOrderDescription());
            ps.setLong(2, deliveryOrder.getProviderId());
            ps.setLong(3, deliveryOrder.getStaffId());
            ps.setDate(4, (Date) deliveryOrder.getPlacementDate());
            ps.setDate(5, (Date) deliveryOrder.getExecutionDate());
            ps.setLong(6, deliveryOrder.getPurchaseId());
            ps.setLong(7, deliveryOrder.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing delivery order was updated successfully!");
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
        String deleteClient = "DELETE FROM delivery_orders WHERE delivery_order_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteClient);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A delivery order was deleted successfully!");
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

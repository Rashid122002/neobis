import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDBHandler implements DAO<Order, Long> {
    private static Connection connection = null;

    @Override
    public List<Order> getAll() {
        String selectAllOrders = "SELECT * FROM orders";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllOrders);
            rs = ps.executeQuery();
            List<Order> orders = new ArrayList<Order>();
            while(rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getLong("order_id"));
                order.setClientId(rs.getLong("client_id"));
                order.setCarId(rs.getLong("car_id"));
                order.setPlacementDate(rs.getDate("placement_date"));
                order.setOrderNumber(rs.getString("order_number"));
                order.setDocumentType(rs.getString("document_type"));
                order.setDocumentNumber(rs.getString("document_number"));
                order.setAddress(rs.getString("address"));
                order.setSaleId(rs.getInt("sale_description_id"));
                orders.add(order);
            }
            return orders;
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
    public Order getById(Long id) {
        String selectOrderById = "SELECT * FROM orders WHERE order_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectOrderById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Order order = new Order();
            while(rs.next()) {
                order.setOrderId(rs.getLong("order_id"));
                order.setClientId(rs.getLong("client_id"));
                order.setCarId(rs.getLong("car_id"));
                order.setPlacementDate(rs.getDate("placement_date"));
                order.setOrderNumber(rs.getString("order_number"));
                order.setDocumentType(rs.getString("document_type"));
                order.setDocumentNumber(rs.getString("document_number"));
                order.setAddress(rs.getString("address"));
                order.setSaleId(rs.getInt("sale_description_id"));
            }
            return order;
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
    public void add(Order order) {
        String insertOrder = "INSERT INTO orders (client_id, car_id, placement_date, order_number, document_type, document_number, address, sale_description_id) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertOrder);
            ps.setLong(1, order.getClientId());
            ps.setLong(2, order.getCarId());
            ps.setDate(3, (Date) order.getPlacementDate());
            ps.setString(4, order.getOrderNumber());
            ps.setString(5, order.getDocumentType());
            ps.setString(6, order.getDocumentNumber());
            ps.setString(7, order.getAddress());
            ps.setInt(8, order.getSaleId());
            ps.executeUpdate();
            System.out.println("The order inserted successfully!");
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Order order) {
        String updateOrder = "UPDATE orders SET client_id=?, car_id=?, placement_date=?, order_number=?, document_type=?, document_number=?, address=?, sale_description_id=? WHERE order_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateOrder);
            ps.setLong(1, order.getClientId());
            ps.setLong(2, order.getCarId());
            ps.setDate(3, (Date) order.getPlacementDate());
            ps.setString(4, order.getOrderNumber());
            ps.setString(5, order.getDocumentType());
            ps.setString(6, order.getDocumentNumber());
            ps.setString(7, order.getAddress());
            ps.setInt(8, order.getSaleId());
            ps.setLong(9, order.getOrderId());
            ps.executeUpdate();
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing order was updated successfully!");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Long id) {
        String deleteOrder = "DELETE FROM orders WHERE order_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteOrder);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An order was deleted successfully!");
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

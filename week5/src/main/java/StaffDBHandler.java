import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDBHandler implements DAO<Staff, Long> {
    private static Connection connection = null;

    @Override
    public List<Staff> getAll() {
        String selectStaff = "SELECT * FROM staff";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectStaff);
            rs = ps.executeQuery();
            List<Staff> staff = new ArrayList<Staff>();
            while (rs.next()) {
                Staff staff1 = new Staff();
                staff1.setStaffId(rs.getLong("staff_id"));
                staff1.setLastName(rs.getString("last_name"));
                staff1.setFirstName(rs.getString("first_name"));
                staff1.setPost(rs.getString("position"));
                staff1.setPhoneNumber(rs.getString("phone_number"));
                staff.add(staff1);
            }
            return staff;
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
    public Staff getById(Long id) {
        String selectStaffById = "SELECT * FROM staff WHERE staff_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectStaffById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Staff staff = new Staff();
            while (rs.next()) {
                staff.setStaffId(rs.getLong("staff_id"));
                staff.setLastName(rs.getString("last_name"));
                staff.setFirstName(rs.getString("first_name"));
                staff.setPost(rs.getString("position"));
                staff.setPhoneNumber(rs.getString("phone_number"));
            }
            return staff;
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
    public void add(Staff staff) {
        String insertStaff = "INSERT INTO staff (last_name, first_name, position, phone_number) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertStaff);
            ps.setString(1, staff.getLastName());
            ps.setString(2, staff.getFirstName());
            ps.setString(3, staff.getPost());
            ps.setString(4, staff.getPhoneNumber());
            ps.executeUpdate();
            System.out.println("The staff inserted successfully!");
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
    public void update(Staff staff) {
        String updateStaff = "UPDATE staff SET last_name=?, first_name=?, position=?, phone_number=? WHERE staff_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateStaff);
            ps.setString(1, staff.getLastName());
            ps.setString(2, staff.getFirstName());
            ps.setString(3, staff.getPost());
            ps.setString(4, staff.getPhoneNumber());
            ps.setLong(5, staff.getStaffId());
            ps.executeUpdate();
            System.out.println("The staff updated successfully!");
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
        String deleteStaff = "DELETE FROM staff WHERE staff_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteStaff);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A staff was deleted successfully!");
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

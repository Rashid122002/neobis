import java.sql.*;

public class StaffDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectStaff() {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.SELECT_STAFF.s);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                long id = rs.getLong("staff_id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String position = rs.getString("position");
                String phoneNumber = rs.getString("phone_number");

                System.out.println("Staff #" + id + " - " + lastName + " - " + firstName + " - " + position + " - " + phoneNumber);
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertStaff(String lastName, String firstName, String position, String phoneNumber) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.INSERT_STAFF.s)) {
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, position);
            ps.setString(4, phoneNumber);

            ps.executeUpdate();
            System.out.println("The staff inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateStaff(long id, String lastName, String firstName, String position, String phoneNumber) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.UPDATE_STAFF.s)) {
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, position);
            ps.setString(4, phoneNumber);
            ps.setLong(5, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing staff was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(long id) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.DELETE_STAFF.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A staff was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

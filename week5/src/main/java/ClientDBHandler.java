import java.sql.*;

public class ClientDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDBConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectClients() {
        try (PreparedStatement ps = getDBConnection().prepareStatement(Statements.SELECT_CLIENTS.s);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("client_id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String phoneNumber = rs.getString("phone_number");
                String notes = rs.getString("notes");

                System.out.println("Client #" + id + " - " + lastName + " - " + firstName + " - " + phoneNumber + " - " + notes);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertClient(String lastName,
                          String firstName,
                          String phoneNumber,
                          String notes) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.INSERT_CLIENT.s)){
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, phoneNumber);
            ps.setString(4, notes);

            ps.executeUpdate();
            System.out.println("The client inserted successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(long id, String lastName, String firstName, String phoneNumber, String notes) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.UPDATE_CLIENT.s)) {
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, phoneNumber);
            ps.setString(4, notes);
            ps.setLong(5, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing client was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(long id) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.DELETE_CLIENT.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A client was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class ProvidersDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectProviders() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_PROVIDERS.s);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                long id = rs.getLong("provider_id");
                String companyName = rs.getString("company_name");
                String companyOfficialName = rs.getString("company_official_name");
                String position = rs.getString("position");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String phone_number = rs.getString("phone_number");
                String fax = rs.getString("fax");
                String paymentTerms = rs.getString("payment_term");

                System.out.println("Provider #" + id + " - " + companyName + " - " + companyOfficialName + " - " +
                        position + " - " + address + " - " + city + " - " + phone_number + " - " + fax + " - " + paymentTerms);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertProvider(String companyName,
                               String companyOfficialName,
                               String position,
                               String address,
                               String city,
                               String phoneNumber,
                               String fax,
                               String paymentTerms) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_PROVIDER.s)) {
            ps.setString(1, companyName);
            ps.setString(2, companyOfficialName);
            ps.setString(3, position);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, phoneNumber);
            ps.setString(7, fax);
            ps.setString(8, paymentTerms);

            ps.executeUpdate();
            System.out.println("The staff inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateProvider(long id,
                               String companyName,
                               String companyOfficialName,
                               String position,
                               String address,
                               String city,
                               String phoneNumber,
                               String fax,
                               String paymentTerms) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_PROVIDER.s)) {
            ps.setString(1, companyName);
            ps.setString(2, companyOfficialName);
            ps.setString(3, position);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, phoneNumber);
            ps.setString(7, fax);
            ps.setString(8, paymentTerms);
            ps.setLong(9, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing provider was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(long id) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_PROVIDER.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A provider was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

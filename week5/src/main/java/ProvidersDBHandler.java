import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvidersDBHandler implements DAO<Provider, Long> {
    private static Connection connection = null;

    @Override
    public List<Provider> getAll() {
        String selectAllProviders = "SELECT * FROM providers";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllProviders);
            rs = ps.executeQuery();
            List<Provider> providers = new ArrayList<Provider>();
            while(rs.next()) {
                Provider provider = new Provider();
                provider.setProviderId(rs.getLong("provider_id"));
                provider.setCompanyName(rs.getString("company_name"));
                provider.setCompanyOfficialName(rs.getString("company_official_name"));
                provider.setPost(rs.getString("position"));
                provider.setAddress(rs.getString("address"));
                provider.setCity(rs.getString("city"));
                provider.setPhoneNumber(rs.getString("phone_number"));
                provider.setFax(rs.getString("fax"));
                provider.setPaymentTerms(rs.getString("payment_term"));
                providers.add(provider);
            }
            return providers;
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
    public Provider getById(Long id) {
        String selectAllProviders = "SELECT * FROM providers WHERE provider_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllProviders);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Provider provider = new Provider();
            while(rs.next()) {
                provider.setProviderId(rs.getLong("provider_id"));
                provider.setCompanyName(rs.getString("company_name"));
                provider.setCompanyOfficialName(rs.getString("company_official_name"));
                provider.setPost(rs.getString("position"));
                provider.setAddress(rs.getString("address"));
                provider.setCity(rs.getString("city"));
                provider.setPhoneNumber(rs.getString("phone_number"));
                provider.setFax(rs.getString("fax"));
                provider.setPaymentTerms(rs.getString("payment_term"));
            }
            return provider;
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
    public void add(Provider provider) {
        String insertProvider = "INSERT INTO providers (company_name, company_official_name, position, address, city, phone_number, fax, payment_term) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertProvider);
            ps.setString(1, provider.getCompanyName());
            ps.setString(2, provider.getCompanyOfficialName());
            ps.setString(3, provider.getPost());
            ps.setString(4, provider.getAddress());
            ps.setString(5, provider.getCity());
            ps.setString(6, provider.getPhoneNumber());
            ps.setString(7, provider.getFax());
            ps.setString(8, provider.getPaymentTerms());
            ps.executeUpdate();
            System.out.println("The provider inserted successfully!");
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
    public void update(Provider provider) {
        String updateProvider = "UPDATE providers SET company_name=?, company_official_name=?, position=?, address=?, city=?, phone_number=?, fax=?, payment_term=? WHERE provider_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateProvider);
            ps.setString(1, provider.getCompanyName());
            ps.setString(2, provider.getCompanyOfficialName());
            ps.setString(3, provider.getPost());
            ps.setString(4, provider.getAddress());
            ps.setString(5, provider.getCity());
            ps.setString(6, provider.getPhoneNumber());
            ps.setString(7, provider.getFax());
            ps.setString(8, provider.getPaymentTerms());
            ps.setLong(9, provider.getProviderId());
            ps.executeUpdate();
            System.out.println("An existing provider was updated successfully!");
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
        String deleteProvider = "DELETE FROM providers WHERE provider_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteProvider);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A client was deleted successfully!");
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

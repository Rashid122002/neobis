import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDescriptionsDBHandler implements DAO<SaleDescription, Integer> {
    private static Connection connection = null;

    @Override
    public List<SaleDescription> getAll() {
        String selectAllSaleDescriptions = "SELECT * FROM sale_descriptions";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllSaleDescriptions);
            rs = ps.executeQuery();
            List<SaleDescription> saleDescriptions = new ArrayList<SaleDescription>();
            while(rs.next()) {
                SaleDescription saleDescription = new SaleDescription();
                saleDescription.setSaleId(rs.getInt("sale_description_id"));
                saleDescription.setDescription(rs.getString("sale_description"));
                saleDescriptions.add(saleDescription);
            }
            return saleDescriptions;
        } catch(SQLException e) {
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
    public SaleDescription getById(Integer id) {
        String selectSaleDescriptionById = "SELECT * FROM sale_descriptions WHERE sale_description_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectSaleDescriptionById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            SaleDescription saleDescription = new SaleDescription();
            while(rs.next()) {
                saleDescription.setSaleId(rs.getInt("sale_description_id"));
                saleDescription.setDescription(rs.getString("sale_description"));
            }
            return saleDescription;
        } catch(SQLException e) {
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
    public void add(SaleDescription saleDescription) {
        String insertSaleDescription = "INSERT INTO sale_descriptions (sale_description) VALUES(?)";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertSaleDescription);
            ps.setString(1, saleDescription.getDescription());
            ps.executeUpdate();
            System.out.println("The sale description inserted successfully!");
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
    public void update(SaleDescription saleDescription) {
        String updateSaleDescription = "UPDATE sale_descriptions SET sale_description=? WHERE sale_description_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateSaleDescription);
            ps.setString(1, saleDescription.getDescription());
            ps.setInt(2, saleDescription.getSaleId());
            ps.executeUpdate();
            System.out.println("The sale description updated successfully!");
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
    public void delete(Integer id) {
        String deleteSaleDescription = "DELETE FROM sale_descriptions WHERE sale_description_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteSaleDescription);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A sale description was deleted successfully!");
            }
        } catch (SQLException e) {
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
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDescriptionsDBHandler implements DAO<PurchaseDescription, Integer> {
    private static Connection connection = null;

    @Override
    public List<PurchaseDescription> getAll() {
        String selectAllPurchaseDescriptions = "SELECT * FROM purchase_descriptions";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllPurchaseDescriptions);
            rs = ps.executeQuery();
            List<PurchaseDescription> purchaseDescriptions = new ArrayList<PurchaseDescription>();
            while(rs.next()) {
                PurchaseDescription purchaseDescription = new PurchaseDescription();
                purchaseDescription.setPurchaseId(rs.getInt("purchase_description_id"));
                purchaseDescription.setDescription(rs.getString("purchase_description"));
                purchaseDescriptions.add(purchaseDescription);
            }
            return purchaseDescriptions;
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
    public PurchaseDescription getById(Integer id) {
        String selectPurchaseDescriptionById = "SELECT * FROM purchase_descriptions WHERE purchase_description_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectPurchaseDescriptionById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            PurchaseDescription purchaseDescription = new PurchaseDescription();
            while(rs.next()) {
                purchaseDescription.setPurchaseId(rs.getInt("purchase_description_id"));
                purchaseDescription.setDescription(rs.getString("purchase_description"));
            }
            return purchaseDescription;
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
    public void add(PurchaseDescription purchaseDescription) {
        String insertPurchaseDescription = "INSERT INTO purchase_descriptions (purchase_description) VALUES(?)";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertPurchaseDescription);
            ps.setString(1, purchaseDescription.getDescription());
            ps.executeUpdate();
            System.out.println("The purchase description inserted successfully!");
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
    public void update(PurchaseDescription purchaseDescription) {
        String insertPurchaseDescription = "UPDATE purchase_descriptions SET purchase_description=? WHERE purchase_description_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertPurchaseDescription);
            ps.setString(1, purchaseDescription.getDescription());
            ps.setInt(2, purchaseDescription.getPurchaseId());
            ps.executeUpdate();
            System.out.println("The purchase description updated successfully!");
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
        String deletePurchaseDescription = "DELETE FROM purchase_descriptions WHERE purchase_description_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deletePurchaseDescription);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A purchase description was deleted successfully!");
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

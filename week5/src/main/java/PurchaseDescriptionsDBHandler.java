import java.sql.*;

public class PurchaseDescriptionsDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectPurchaseDescriptions() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_PURCHASE_DESCRIPTIONS.s);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                long id = rs.getLong("purchase_description_id");
                String description = rs.getString("purchase_description");

                System.out.println("Purchase description #" + id + " - " + description);
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertPurchaseDescription(String description) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_PURCHASE_DESCRIPTION.s)) {
            ps.setString(1, description);
            ps.executeUpdate();
            System.out.println("The purchase description inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePurchaseDescription(long id, String description) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_PURCHASE_DESCRIPTION.s)) {
            ps.setString(1, description);
            ps.setLong(2, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing purchase description was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletePurchaseDescription(long id) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_PURCHASE_DESCRIPTION.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A purchase description was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

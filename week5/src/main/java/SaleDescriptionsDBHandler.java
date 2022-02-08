import java.sql.*;

public class SaleDescriptionsDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectSaleDescriptions() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_SALE_DESCRIPTIONS.s);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                long id = rs.getLong("sale_description_id");
                String description = rs.getString("sale_description");

                System.out.println("Sale description #" + id + " - " + description);
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertSaleDescription(String description) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_SALE_DESCRIPTION.s)) {
            ps.setString(1, description);

            ps.executeUpdate();
            System.out.println("The sale description inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateSaleDescription(long id, String description) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_SALE_DESCRIPTION.s)) {
            ps.setString(1, description);
            ps.setLong(2, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing sale description was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteSaleDescription(long id) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_SALE_DESCRIPTION.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A sale description was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

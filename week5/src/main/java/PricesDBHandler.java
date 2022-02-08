import java.sql.*;

public class PricesDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectPrices() {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.SELECT_PRICES.s);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                long id = rs.getLong("price_id");
                double salePrice = rs.getDouble("sale_price");

                System.out.println("Price #" + id + " - " + salePrice);
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertPrice(double salePrice) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.INSERT_PRICE.s)) {
            ps.setDouble(1, salePrice);

            ps.executeUpdate();
            System.out.println("The price inserted successfully!");
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(long id, double salePrice) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.UPDATE_PRICE.s)) {
            ps.setDouble(1, salePrice);
            ps.setLong(2, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing price was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletePrice(long id) {
        try(PreparedStatement ps = getDbConnection().prepareStatement(Statements.DELETE_PRICE.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A price was deleted successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

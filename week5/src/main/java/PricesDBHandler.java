import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PricesDBHandler implements DAO<Price, Integer> {
    private static Connection connection = null;

    @Override
    public List<Price> getAll() {
        String selectAllPrices = "SELECT * FROM prices";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllPrices);
            rs = ps.executeQuery();
            List<Price> prices = new ArrayList<Price>();
            while(rs.next()) {
                Price price = new Price();
                price.setPriceId(rs.getInt("price_id"));
                price.setSalePrice(rs.getDouble("sale_price"));
                prices.add(price);
            }
            return prices;
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
    public Price getById(Integer id) {
        String selectPriceById = "SELECT * FROM prices WHERE price_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectPriceById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Price price = new Price();
            while(rs.next()) {
                price.setPriceId(rs.getInt("price_id"));
                price.setSalePrice(rs.getDouble("sale_price"));
            }
            return price;
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
    public void add(Price price) {
        String insertPrice = "INSERT INTO prices (sale_price) VALUES(?)";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertPrice);
            ps.setDouble(1, price.getSalePrice());
            ps.executeUpdate();
            System.out.println("The price inserted successfully!");
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
    public void update(Price price) {
        String updatePrice = "UPDATE prices SET sale_price=? WHERE price_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updatePrice);
            ps.setDouble(1, price.getSalePrice());
            ps.setInt(2, price.getPriceId());
            ps.executeUpdate();
            System.out.println("An existing price was updated successfully!");
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
        String deletePrice = "DELETE FROM prices WHERE price_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deletePrice);
            ps.setLong(1, id);
            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0) {
                System.out.println("A price was deleted successfully!");
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

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsDBHandler implements DAO<Car, Long> {
    private static Connection connection = null;

    @Override
    public List<Car> getAll() {
        String selectAllCars = "SELECT * FROM Cars";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectAllCars);
            rs = ps.executeQuery();
            List<Car> cars = new ArrayList<Car>();
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getLong("car_id"));
                car.setCarBrand(rs.getString("car_brand"));
                car.setSerialNumber(rs.getString("serial_number"));
                car.setYearOfManufacture(rs.getDate("year_of_manufacture"));
                car.setEngineCapacity(rs.getString("engine_capacity"));
                car.setCarColor(rs.getString("car_color"));
                car.setPriceId(rs.getInt("price_id"));
                car.setNotes(rs.getString("notes"));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try{
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public Car getById(Long id) {
        String selectCarById = "SELECT * FROM cars WHERE car_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(selectCarById);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Car car = new Car();
            while(rs.next()) {
                car.setCarId(rs.getLong("car_id"));
                car.setCarBrand(rs.getString("car_brand"));
                car.setSerialNumber(rs.getString("serial_number"));
                car.setYearOfManufacture(rs.getDate("year_of_manufacture"));
                car.setEngineCapacity(rs.getString("engine_capacity"));
                car.setCarColor(rs.getString("car_color"));
                car.setPriceId(rs.getInt("price_id"));
                car.setNotes(rs.getString("notes"));
            }
            return car;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            try{
                if(connection != null)
                    connection.close();
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void add(Car car) {
        String insertCar = "INSERT INTO cars (car_brand, serial_number, year_of_manufacture, " +
                "engine_capacity, car_color, price_id, notes) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(insertCar);
            ps.setString(1, car.getCarBrand());
            ps.setString(2, car.getSerialNumber());
            ps.setDate(3, car.getYearOfManufacture());
            ps.setString(4, car.getEngineCapacity());
            ps.setString(5, car.getCarColor());
            ps.setLong(6, car.getPriceId());
            ps.setString(7, car.getNotes());
            ps.executeUpdate();
            System.out.println("The car inserted successfully!");
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

    @Override
    public void update(Car car) {
        String updateCar = "UPDATE cars SET car_brand=?, serial_number=?, year_of_manufacture=?, " +
                "engine_capacity=?, car_color=?, price_id=?, notes=? WHERE car_id=?";
        PreparedStatement ps = null;
        try {
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(updateCar);
            ps.setString(1, car.getCarBrand());
            ps.setString(2, car.getSerialNumber());
            ps.setDate(3, car.getYearOfManufacture());
            ps.setString(4, car.getEngineCapacity());
            ps.setString(5, car.getCarColor());
            ps.setInt(6, car.getPriceId());
            ps.setString(7, car.getNotes());
            ps.setLong(8, car.getCarId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing car was updated successfully!");
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

    @Override
    public void delete(Long id) {
        String deleteCar = "DELETE FROM cars WHERE car_id=?";
        PreparedStatement ps = null;
        try{
            connection = DBCPDataSource.getConnection();
            ps = connection.prepareStatement(deleteCar);
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A car was deleted successfully!");
            }
        } catch(SQLException e) {
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

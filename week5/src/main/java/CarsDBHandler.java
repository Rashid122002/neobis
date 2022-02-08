import java.sql.*;
import java.time.LocalDate;

public class CarsDBHandler extends Configs {
    Connection dbConnection = null;

    public Connection getDBConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return dbConnection;
    }

    public void selectCars() {
        try (PreparedStatement ps = getDBConnection().prepareStatement(Statements.SELECT_CARS.s);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("car_id");
                String carBrand = rs.getString("car_brand");
                String serialNumber = rs.getString("serial_number");
                Date yearOfManufacture = rs.getDate("year_of_manufacture");
                String engineCapacity = rs.getString("engine_capacity");
                String carColor = rs.getString("car_color");
                long priceId = rs.getLong("price_id");
                String notes = rs.getString("notes");
                System.out.println("Car #" + id + " - " + carBrand + " - " + serialNumber + " - " + yearOfManufacture + " - " + engineCapacity + " - " + carColor + " - " + priceId + " - " + notes);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertCar(String carBrand,
                          String serialNumber,
                          LocalDate yearOfManufacture,
                          String engineCapacity,
                          String carColor,
                          long priceId,
                          String notes) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.INSERT_CAR.s)){
            ps.setString(1, carBrand);
            ps.setString(2, serialNumber);
            ps.setDate(3, java.sql.Date.valueOf(yearOfManufacture));
            ps.setString(4, engineCapacity);
            ps.setString(5, carColor);
            ps.setLong(6, priceId);
            ps.setString(7, notes);

            ps.executeUpdate();
            System.out.println("The car inserted successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(long id,
                          String carBrand,
                          String serialNumber,
                          LocalDate yearOfManufacture,
                          String engineCapacity,
                          String carColor,
                          long priceId,
                          String notes) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.UPDATE_CAR.s)) {
            ps.setString(1, carBrand);
            ps.setString(2, serialNumber);
            ps.setDate(3, java.sql.Date.valueOf(yearOfManufacture));
            ps.setString(4, engineCapacity);
            ps.setString(5, carColor);
            ps.setLong(6, priceId);
            ps.setString(7, notes);
            ps.setLong(8, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing car was updated successfully!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(long id) {
        try(PreparedStatement ps = getDBConnection().prepareStatement(Statements.DELETE_CAR.s)) {
            ps.setLong(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A car was deleted successfully!");
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

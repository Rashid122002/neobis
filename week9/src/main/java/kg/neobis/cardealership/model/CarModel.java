package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {
    private Long carId;
    private String carBrand;
    private String serialNumber;
    private LocalDate yearOfManufacture;
    private String engineCapacity;
    private String carColor;
    private Price priceId;
    private String notes;

    public static CarModel carToCarModel(Car car) {
        CarModel carModel = new CarModel();
        carModel.setCarId(car.getCarId());
        carModel.setCarBrand(car.getCarBrand());
        carModel.setSerialNumber(car.getSerialNumber());
        carModel.setYearOfManufacture(car.getYearOfManufacture());
        carModel.setEngineCapacity(car.getEngineCapacity());
        carModel.setCarColor(car.getCarColor());
        carModel.setPriceId(car.getPriceId());
        carModel.setNotes(car.getNotes());
        return carModel;
    }
}

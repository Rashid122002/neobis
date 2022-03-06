package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Car;
import kg.neobis.cardealership.Repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> all() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find car ", id));
    }

    public void addNewCar(@RequestBody Car newCar) {
        carRepository.save(newCar);
    }

    public Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setCarBrand(newCar.getCarBrand());
                    car.setSerialNumber(newCar.getSerialNumber());
                    car.setYearOfManufacture(newCar.getYearOfManufacture());
                    car.setEngineCapacity(newCar.getEngineCapacity());
                    car.setCarColor(newCar.getCarColor());
                    car.setPriceId(newCar.getPriceId());
                    car.setNotes(newCar.getNotes());
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    newCar.setCarId(id);
                    return carRepository.save(newCar);
                });
    }

    public void deleteCarById(@PathVariable Long id) {
        boolean exists = carRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find car ", id);
        }
        carRepository.deleteById(id);
    }
}

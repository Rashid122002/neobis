package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.model.CarModel;
import kg.neobis.cardealership.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.CarModel.carToCarModel;

@Service
public class CarService implements DAO<Car, CarModel, Long>  {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarModel> entityListToModelList(Iterable<Car> cars) {
        List<CarModel> carModelList = new ArrayList<CarModel>();
        for (Car car : cars)
        {
            carModelList.add(carToCarModel(car));
        }
        return carModelList;
    }

    @Override
    public List<CarModel> getAll() {
        return entityListToModelList(carRepository.findAll());
    }

    @Override
    public CarModel getById(Long id) throws EntityNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found car: ", id));
        return carToCarModel(car);
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car update(CarModel carModel, Long id) throws EntityNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found car: ", id));
        car.setCarBrand(carModel.getCarBrand());
        car.setSerialNumber(carModel.getSerialNumber());
        car.setYearOfManufacture(carModel.getYearOfManufacture());
        car.setEngineCapacity(carModel.getEngineCapacity());
        car.setCarColor(carModel.getCarColor());
        car.setPriceId(carModel.getPriceId());
        car.setNotes(carModel.getNotes());
        return carRepository.save(car);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!carRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found car: ", id);
        }
        carRepository.deleteById(id);
        return id;
    }
}

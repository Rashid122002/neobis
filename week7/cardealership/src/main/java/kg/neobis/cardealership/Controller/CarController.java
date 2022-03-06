package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Car;
import kg.neobis.cardealership.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.all();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public void registerNewCar(@RequestBody Car newCar) {
        carService.addNewCar(newCar);
    }

    @PutMapping("/{id}")
    public Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {
        return carService.replaceCar(newCar, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}

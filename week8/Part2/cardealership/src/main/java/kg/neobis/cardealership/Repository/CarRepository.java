package kg.neobis.cardealership.Repository;

import kg.neobis.cardealership.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

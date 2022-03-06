package kg.neobis.cardealership.Repository;

import kg.neobis.cardealership.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}

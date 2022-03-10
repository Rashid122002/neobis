package kg.neobis.cardealership.repository;

import kg.neobis.cardealership.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}

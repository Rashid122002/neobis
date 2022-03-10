package kg.neobis.cardealership.repository;

import kg.neobis.cardealership.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

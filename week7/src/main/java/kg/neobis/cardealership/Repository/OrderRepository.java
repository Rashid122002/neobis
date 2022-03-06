package kg.neobis.cardealership.Repository;

import kg.neobis.cardealership.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

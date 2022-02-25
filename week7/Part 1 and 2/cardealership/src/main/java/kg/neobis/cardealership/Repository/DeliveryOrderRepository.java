package kg.neobis.cardealership.Repository;

import kg.neobis.cardealership.Model.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
}

package kg.neobis.cardealership.repository;

import kg.neobis.cardealership.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}

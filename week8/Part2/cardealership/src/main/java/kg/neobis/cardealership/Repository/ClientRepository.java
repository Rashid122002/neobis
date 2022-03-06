package kg.neobis.cardealership.Repository;

import kg.neobis.cardealership.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

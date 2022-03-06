package kg.neobis.cardealership.security.repo;

import kg.neobis.cardealership.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}

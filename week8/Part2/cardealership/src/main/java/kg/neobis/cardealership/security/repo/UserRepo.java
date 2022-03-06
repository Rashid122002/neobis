package kg.neobis.cardealership.security.repo;

import kg.neobis.cardealership.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

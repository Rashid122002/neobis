package kg.neobis.cardealership.repository;

import kg.neobis.cardealership.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

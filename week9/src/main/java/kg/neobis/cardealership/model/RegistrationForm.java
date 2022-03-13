package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Role;
import kg.neobis.cardealership.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String email;
    private String phone;

    public RegistrationForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUser(BCryptPasswordEncoder bCryptPasswordEncoder) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        return user;
    }
}

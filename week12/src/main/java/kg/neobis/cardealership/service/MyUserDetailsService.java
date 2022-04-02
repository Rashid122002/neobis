package kg.neobis.cardealership.service;

import kg.neobis.cardealership.entity.User;
import kg.neobis.cardealership.jwt.JwtProvider;
import kg.neobis.cardealership.model.RegistrationForm;
import kg.neobis.cardealership.model.UserAuthModel;
import kg.neobis.cardealership.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            return user;
        }
    }

    public void registerUser(RegistrationForm registrationForm) {
        User user = userRepository.findByUsername(registrationForm.getUsername());
        if (user != null) {
            throw new UsernameNotFoundException("This username is exist");
        } else{
            userRepository.save(registrationForm.toUser(passwordEncoder));
        }
    }

    public String getUserAuthenticationToken(UserAuthModel userAuthModel) {
        UserAuthModel authModel = findByUsernameAndPassword(userAuthModel.getUsername(), userAuthModel.getPassword());
        return jwtProvider.generateToken(authModel.getUsername());
    }

    public UserAuthModel findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        UserAuthModel userModel = new UserAuthModel();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());
        return userModel;
    }

    public UserAuthModel findByUsernameAndPassword(String username, String password) {
        UserAuthModel userAuthModel = findByUsername(username);
        if (userAuthModel != null) {
            if (passwordEncoder.matches(password, userAuthModel.getPassword())) {
                return userAuthModel;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

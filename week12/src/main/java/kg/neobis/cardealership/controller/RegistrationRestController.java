package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.model.RegistrationForm;
import kg.neobis.cardealership.service.MyUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class RegistrationRestController {

    private final MyUserDetailsService userService;

    public RegistrationRestController(MyUserDetailsService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationForm registrationForm) {
        try {
            userService.registerUser(registrationForm);
            return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

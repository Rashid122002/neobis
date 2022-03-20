package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.exception.UserNotAuthorizedException;
import kg.neobis.cardealership.model.AuthResponse;
import kg.neobis.cardealership.model.UserAuthModel;
import kg.neobis.cardealership.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AuthRestController {

    @Autowired
    private MyUserDetailsService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody UserAuthModel userModel) {
        try {
            AuthResponse response = new AuthResponse();
            response.setToken(userService.getUserAuthenticationToken(userModel));
            return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

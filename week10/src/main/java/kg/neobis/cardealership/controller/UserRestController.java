package kg.neobis.cardealership.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserRestController {

    @GetMapping("user")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("Congratulations! It works! This is User Page!", HttpStatus.OK);
    }
}

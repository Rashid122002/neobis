package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AdminRestController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return new ResponseEntity<>("It works! This is Admin Page!", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(myUserDetailsService.getAllUsers(), HttpStatus.OK);
    }
}

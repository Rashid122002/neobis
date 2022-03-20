package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.model.RegistrationForm;
import kg.neobis.cardealership.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String processUser(RegistrationForm user) {
        myUserDetailsService.registerUser(user);
        return "redirect:/login";
    }
}

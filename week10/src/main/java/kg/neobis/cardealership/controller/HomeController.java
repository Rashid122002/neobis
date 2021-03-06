package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {

        if (user != null) {
            model.addAttribute("user", "Welcome, " + user.getUsername());
            return "index";
        }
        model.addAttribute("user", "Welcome, anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/foruser")
    public String forUser() {
        return "foruser";
    }
}

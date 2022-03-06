package kg.neobis.cardealership.security.controller;

import kg.neobis.cardealership.security.domain.User;
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
            model.addAttribute("user", user.getUsername());
            return "index";
        }
        model.addAttribute("user", "anonymous");
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

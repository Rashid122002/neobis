package kg.neobis.cardealership.security.controller;

import kg.neobis.cardealership.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foradmin")
public class AdminController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("allUsers", myUserDetailsService.getAllUsers());
        return "foradmin";
    }
}

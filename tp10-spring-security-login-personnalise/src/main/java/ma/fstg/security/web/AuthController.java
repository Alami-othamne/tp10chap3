package ma.fstg.security.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "admin-dashboard";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user-dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}

package org.example.bootsecurityplus.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/a")
    // Authentication - 이것만 알면...
    public String a(Model model, Authentication authentication) {
        model.addAttribute("msg", "a-admin");
        model.addAttribute("name", authentication.getName());
        return "index";
    }

    @GetMapping("/b")
    public String b(Model model) {
        model.addAttribute("msg", "b-admin");
        return "index";
    }
}

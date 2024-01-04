package com.example.daoucoupon.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("message", "Hello, Spring Boot!");
        return "main";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }



}

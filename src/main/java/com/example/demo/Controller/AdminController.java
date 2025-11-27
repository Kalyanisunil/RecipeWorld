package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String home() {
        return "Admin";
    }


    @GetMapping("/login")
    public String login() {
        return "Login";
    }


}

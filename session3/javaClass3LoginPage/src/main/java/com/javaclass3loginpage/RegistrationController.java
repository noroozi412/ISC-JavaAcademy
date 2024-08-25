package com.javaclass3loginpage;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping ("/register")
    public String processRegistrationForm(@RequestParam ("name") String name,
                                          @RequestParam("family") String family,
                                          @RequestParam("yearOfBirth") int yearOfBirth, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("family", family);
        model.addAttribute("yearOfBirth", yearOfBirth);
        return "result";

    }
}
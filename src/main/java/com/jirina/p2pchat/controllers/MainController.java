package com.jirina.p2pchat.controllers;


import com.jirina.p2pchat.models.User;
import com.jirina.p2pchat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public String login (Model model) {
        if (userRepo.count() < 1) {
            return "redirect:/register";
        } else if ()
        {
            String userApp = "App";
            model.addAttribute("userApp",userApp);
            String defaultMessage = "Hi there! Submit your message using the send button!";
            model.addAttribute("defaultMessage", defaultMessage);









        };
    }

    @GetMapping("/register")
    public String register() {
        if (userRepo.count() > 0) {
            return ("redirect:/");
        } else return ("register");
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, Model model) {
        if (username.equals("")) {
            String errormessage = "The username field is empty.";
            model.addAttribute("errormessage", errormessage);
            return "/register";
        } else {
            userRepo.save(new User(username));
            return "redirect:/";
        }
    }


}

package com.jirina.p2pchat.controllers;


import com.jirina.p2pchat.models.Message;
import com.jirina.p2pchat.models.User;
import com.jirina.p2pchat.repositories.MesssageRepository;
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
    @Autowired
    MesssageRepository messageRepo;

    User actualUser ;

    @GetMapping("/")
    public String login() {
        if (userRepo.count() < 1) {
            return "redirect:/register";
        } else return "index";
    }

    @PostMapping("/nick")
    public String nick(@RequestParam String nickname, Model model) {
        if (nickname.equals("")) {
            model.addAttribute("errormessage", "The username field is empty.");
        } else {
            this.actualUser = userRepo.findById(1l).get();
            model.addAttribute("userApp", "App");
            model.addAttribute("defaultMessage", "Hi there! Submit your message using the send button!");
            actualUser.setUsername(nickname);
            userRepo.save(actualUser);
        }
        return ("index");
    }

    @PostMapping ("/newMessage")
    public  String newMessage (@RequestParam String newmessage, Model model){
        Message lastMessage = new Message(userRepo.findById(1l).get(), newmessage);
        messageRepo.save(lastMessage);
        model.addAttribute("newMessage", newmessage);
        model.addAttribute("actualUserName", actualUser.getUsername());
        model.addAttribute("messages", messageRepo.findAll());

        return "index";
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

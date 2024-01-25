package com.pack.fiaraoccaz.controller;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.dto.UserLoginRequest;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        User user = userService.loginUser(request.getEmail(), request.getPassword());

        if (user != null) {
            return "Connexion réussie!";
        } else {
            return "Identifiants incorrects.";
        }
    }

    public User signUp(@RequestBody User user){
        return userService.signUp(user);
    }
}

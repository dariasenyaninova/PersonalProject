package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public String registration(@RequestBody User user){
        boolean registered = userService.registration(user);
        if(registered){
            return "Registration complete!";
        }else{
            return "This email is already registered!";
        }
    }

    @DeleteMapping("/deleteUser")
    public String deleteUserById(@RequestParam String token){
        boolean deleted = userService.deleteUser(token);
        if(deleted){
            return "User deleted";
        }else{
            return "Invalid token";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String token){
        boolean logout = userService.logout(token);
        if(logout){
            return "You successfully logged out";
        }else{
            return "Invalid token";
        }
    }

}

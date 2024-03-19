package com.example.userserviceproject.Controllers;

import com.example.userserviceproject.DTOs.LoginRequestDTO;
import com.example.userserviceproject.DTOs.SignupRequestDTO;
import com.example.userserviceproject.Models.User;
import com.example.userserviceproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public User login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.login(loginRequestDTO);
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody SignupRequestDTO signupRequestDTO){
        return userService.signup(signupRequestDTO);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(){
        userService.logout();
        return  null;
    }
}

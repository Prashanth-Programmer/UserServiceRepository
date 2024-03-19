package com.example.userserviceproject.Services;

import com.example.userserviceproject.DTOs.LoginRequestDTO;
import com.example.userserviceproject.DTOs.SignupRequestDTO;
import com.example.userserviceproject.Models.User;
import com.example.userserviceproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User login(LoginRequestDTO loginRequestDTO){
        Optional<User> result = userRepository.findByEmailAndHashedPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        if(result.isEmpty() == true){
            return null;
        }
        else{
            return result.get();
        }
    }
    public void logout(){
        return;
    }
    public User signup(SignupRequestDTO signupRequestDTO){
        User user = new User();
        user.setEmail(signupRequestDTO.getEmail());
        user.setHashedPassword(signupRequestDTO.getPassword());
        user.setName(signupRequestDTO.getName());
        return userRepository.save(user);
    }
}

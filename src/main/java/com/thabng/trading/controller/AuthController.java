package com.thabng.trading.controller;


import com.thabng.trading.Repository.UserRepository;
import com.thabng.trading.Service.UserService;
import com.thabng.trading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;
     @PostMapping("/signup")
     public User registerUser(@RequestBody User user){

//         //Create new user
//         User newUser = new User();
//
//         newUser.setEmail(user.getEmail());
//         newUser.setFullName(user.getFullName());
//         newUser.setPassword(newUser.getPassword());
//         newUser.setRole(newUser.getRole());

         return userService.createUser(user);
     }
}

package com.usa.ciclo4.zorrillo.controller;

import java.util.List;

import com.usa.ciclo4.zorrillo.model.User;
import com.usa.ciclo4.zorrillo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();   
    }    

    @PostMapping("/new")
    public User registeUser(@RequestBody User user) {       
        return userService.registerUser(user);
    }
  
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticatheUser(email,password);
    }   

    @GetMapping("/{email}")
    public boolean emailExist(@PathVariable("email") String email){
        return userService.emailExist(email);
    }

}

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author: Alix Rincón
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    /**
     * UserService 
     */
    @Autowired
    private UserService userService;

    /**
     * 
     * @return UserService
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();   
    }    

    /**
     * 
     * @param user
     * @return UserService
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void registeUser(@RequestBody User user) {       
        userService.registerUser(user);
    }

    /**
   * 
   * @param email
   * @param password
   * @return
   */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticatheUser(email,password);
    }   

    /**
     * @return UserService
     */
    @GetMapping("/{email}")
    public boolean emailExist(@PathVariable("email") String email){
        return userService.emailExist(email);
    }

}

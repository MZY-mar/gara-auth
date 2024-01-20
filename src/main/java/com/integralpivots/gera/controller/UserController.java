package com.integralpivots.gera.controller;


import com.integralpivots.gera.domain.User;
import com.integralpivots.gera.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;
    @GetMapping("/info")
    public String getServiceInfo(){
        return "Welcome to Gera Auth Service";
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepo.saveUser(user);
    }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable("userId") String id){
        return userRepo.findUserById(Long.valueOf(id));
    }

    @GetMapping("/user/email/{email}")
    public  User findUserByEmail(@PathVariable("email") String email){
        return userRepo.findUserByEmail(email);
    }
    //user id and alias not need to wrap in to user object
    @PutMapping("/user/{userId}/alias/{alias}")
    public User updateUserAlias(@PathVariable("userId") String userid,
                                @PathVariable("alias") String alias){
        return  userRepo.updateAlias(Long.valueOf(userid),alias);
    }




}

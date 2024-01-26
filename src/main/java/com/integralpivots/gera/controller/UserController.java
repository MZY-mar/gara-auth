package com.integralpivots.gera.controller;
import com.integralpivots.gera.GeraRes;
import com.integralpivots.gera.RedisService;
import com.integralpivots.gera.domain.User;
import com.integralpivots.gera.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RedisService redisService;


    @PostMapping("/user/register")
    public GeraRes registerValidateUser(){

    }
    @GetMapping("/info")
    public String getServiceInfo(){
        return "Welcome to Gera Auth Service";
    }

    @PostMapping("/user")
    public GeraRes createUser(@RequestBody User user){
        return GeraRes.ok().data("user", userRepo.saveUser(user));
    }

    @GetMapping("/user/{userId}")
    public GeraRes findUserById(@PathVariable("userId") String id){
        return GeraRes.ok().data("user",
                userRepo.findUserById(Long.valueOf(id)));
    }

    @GetMapping("/user/email/{email}")
    public GeraRes findUserByEmail(@PathVariable("email") String email){
       return GeraRes.ok().data("user",userRepo.findUserByEmail(email));
    }
    //user id and alias not need to wrap in to user object
    @PutMapping("/user/{userId}/alias/{alias}")
    public GeraRes updateUserAlias(@PathVariable("userId") String userId,
                                   @PathVariable("alias") String alias){
       User user = userRepo.updateAlias(Long.valueOf(userId),alias);
       return GeraRes.ok().data("user",user);
    }




}

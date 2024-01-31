package com.integralpivots.gera.controller;


import com.integralpivots.gera.*;
import com.integralpivots.gera.application.GeraEmailService;
import com.integralpivots.gera.controller.inDto.RegisterValidateEmail;
import com.integralpivots.gera.domain.User;
import com.integralpivots.gera.domain.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class UserController {


    @Autowired
    UserRepo userRepo;
    @Autowired
    RedisService redisService;

    @Autowired
    GeraEmailService geraEmailService;



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
    @PostMapping("/user/register-verify")
    public GeraRes registerValidateUser(@RequestBody RegisterValidateEmail registerValidateEmail) {
        if(Objects.nonNull(userRepo.findUserByEmail(registerValidateEmail.getEmail()))){
            throw  GeraException.builder().code(GeraException.DATA_ALREADY_EXIST).message("Email already registered.").build();
        }
        String verificationCode = VerificationCodeGenerator.generate();
        redisService.setValueWithExpireMinutes(registerValidateEmail.getEmail()+ RedisKeyUtil.registerVerificationCodeSuffix,verificationCode,5);
        GeraRes geraRes = geraEmailService.sendRegisterUrlEmail(EmailRequest.builder().to(registerValidateEmail.getEmail()).content(verificationCode).build());

        if (!geraRes.getSuccess()) {
            throw GeraException.builder().code(GeraException.SERVER_INTERNAL_ERROR).message("Send register verification url failed").build();
        }

        return GeraRes.ok();

    }



}

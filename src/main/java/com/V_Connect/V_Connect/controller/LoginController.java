package com.V_Connect.V_Connect.controller;


import com.V_Connect.V_Connect.model.MyUser;
import com.V_Connect.V_Connect.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    LoginService loginService;

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("All Good :)", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MyUser user){
        return loginService.register(user);
    }


    @GetMapping("/btamujhe")
    public ResponseEntity<String> btaMujhe(){
        return new ResponseEntity<>("Ha kaam kr rha",HttpStatus.OK);
    }




}

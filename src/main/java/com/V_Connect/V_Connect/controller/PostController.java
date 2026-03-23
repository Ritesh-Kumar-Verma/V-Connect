package com.V_Connect.V_Connect.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


    public ResponseEntity<String> addPost(){

        return new ResponseEntity<>("Success", HttpStatus.OK);
        
    }



}

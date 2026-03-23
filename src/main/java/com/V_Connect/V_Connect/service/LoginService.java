package com.V_Connect.V_Connect.service;


import com.V_Connect.V_Connect.model.MyUser;
import com.V_Connect.V_Connect.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    MyUserRepo myUserRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> register(MyUser user) {

        if (user.getEmail() == null || user.getUsername() == null || user.getPassword() == null){
            return new ResponseEntity<>("Insuficient Data",HttpStatus.NOT_ACCEPTABLE);
        }

        Optional<MyUser> user1 = myUserRepo.findByUsername(user.getUsername());

        if(user1.isPresent()){
            return new ResponseEntity<>("Username Already Exist", HttpStatus.NOT_ACCEPTABLE);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        myUserRepo.save(user);
        return new ResponseEntity<>(jwtService.generateToken(user) , HttpStatus.OK);

    }


    public ResponseEntity<String> login(MyUser myUser) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(),myUser.getPassword()));

        if(authentication.isAuthenticated()){
            return new ResponseEntity<>( jwtService.generateToken(myUser),HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong Credential",HttpStatus.NOT_FOUND);

    }








}

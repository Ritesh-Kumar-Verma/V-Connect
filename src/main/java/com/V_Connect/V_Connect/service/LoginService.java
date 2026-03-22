package com.V_Connect.V_Connect.service;


import com.V_Connect.V_Connect.model.MyUser;
import com.V_Connect.V_Connect.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    MyUserRepo myUserRepo;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> register(MyUser user) {
        Optional<MyUser> user1 = myUserRepo.findByUsername(user.getUsername());

        if(user1.isPresent()){
            return new ResponseEntity<>("Username Already Exist", HttpStatus.NOT_ACCEPTABLE);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        myUserRepo.save(user);
        return new ResponseEntity<>("Success" , HttpStatus.OK);

    }





}

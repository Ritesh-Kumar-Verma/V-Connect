package com.V_Connect.V_Connect.service;

import com.V_Connect.V_Connect.model.MyUser;
import com.V_Connect.V_Connect.model.MyUserDetails;
import com.V_Connect.V_Connect.repo.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    MyUserRepo myUserRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepo.findByUsername(username);


        if(user.isPresent()){
            return new MyUserDetails(user.get());
        }
        throw new UsernameNotFoundException("User not Found");

    }





}

package com.V_Connect.V_Connect.repo;

import com.V_Connect.V_Connect.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Integer> {
    Optional<MyUser> findByUsername(String username);
}

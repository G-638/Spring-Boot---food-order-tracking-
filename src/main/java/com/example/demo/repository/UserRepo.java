package com.example.demo.repository;

import com.example.demo.model.TableOrder;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String username);

//    @Query("select u from user u where u.branch=:branch")
//    ArrayList<User> findUserByBranch(@Param("branch") String branch);
}
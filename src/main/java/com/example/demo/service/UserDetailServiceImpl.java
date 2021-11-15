package com.example.demo.service;

import com.example.demo.exception.SpringAuthenticationException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    User user;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
        }
        throw new SpringAuthenticationException(SpringAuthenticationException.ErrorMessages.USERNAME_NOT_FOUND);

    }

    public User getUserData(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByEmail(auth.getName());
        return user;
    }

    public ArrayList<User> getUserData(String branch){
        List<User> user = userRepo.findAll();
        ArrayList<User> userData = new ArrayList<>();
        user.forEach(it->{
            System.out.println(it.getRole());
            if(it.getRole().equals("user")){
                if(it.getBranch().equals(branch)) {
                    userData.add(it);
                    System.out.println(it.getEmail());
                }
            }
            else{
                System.out.println("no");
            }
        });
        return userData;
    }

    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }

}

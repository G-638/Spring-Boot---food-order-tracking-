package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import com.example.demo.model.User;
import com.example.demo.model.requestModel.RequestFromUser;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.demo.Constant.SIGNUP_SUCCESS;


@RequestMapping("/api/foodorder")
@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    String singUp(@ModelAttribute RequestFromUser user, Model model){
        String username = user.getUsername();
        if(username == null){
            model.addAttribute("error", "INVALID_USERNAME");
            return "signup";
        }
        String password = user.getPassword();
        if(password == null || password.length() < 6){
            model.addAttribute("error", "INVALID_PASSWORD");
            return "signup";
        }
        User currentUser = userRepo.findByEmail(username);
        if(currentUser != null) {
            model.addAttribute("error", "USERNAME_ALREADY_EXIST");
            return "signup";
        }
        User castedUser = new User(user.getUsername(),passwordEncoder.encode(user.getPassword()));
        castedUser.setUid(getUniqueId());
        castedUser.setEmail(user.getUsername());
        userRepo.save(castedUser);

        model.addAttribute("info", SIGNUP_SUCCESS);
        return "signup";
    }

    @GetMapping("/signup")
    String signUpPage(){
        return "signup";
    }


    @GetMapping("/users")
    String getAllUsers(Model model){
        if(userRepo.findAll().isEmpty()){
            throw new CustomException(CustomException.ErrorMessage.EMPTY_LIST);
        }
        List<User> users = userRepo.findAll();
        model.addAttribute("userList", users);
        return "users";
    }


    String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}

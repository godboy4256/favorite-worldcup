package com.example.wc_web.controller.user;

import com.example.wc_web.dto.user.CreateUserRequest;
import com.example.wc_web.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

   private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody CreateUserRequest request){
        userService.createUser(request);
    }
}

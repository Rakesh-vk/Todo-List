package com.Rakesh.Todo.List.Controllers;

import com.Rakesh.Todo.List.Models.User;
import com.Rakesh.Todo.List.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public User getCurrentUser(@RequestBody User user){
        System.out.println("GET username and password *****");
        return userService.getUser(user);
    }

    @GetMapping("/loging/{username}/{password}")
    public boolean findUserByUsername(@PathVariable String username, @PathVariable String password){
        System.out.println("GET username and password *****");
        return userService.getUserByUsername(username,password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user){
        boolean user_exits = userService.findUserByUsername(user.getUsername());
        if(user_exits){
            System.out.println("Cant create user!");
            return false;
        }
        userService.saveUser(user);
        return true;
    }

}

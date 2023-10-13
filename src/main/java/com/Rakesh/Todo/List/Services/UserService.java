package com.Rakesh.Todo.List.Services;

import com.Rakesh.Todo.List.Models.User;
import com.Rakesh.Todo.List.Repositories.UserRepo;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUser(User user){
        System.out.println("Service Get *******");
        return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public boolean getUserByUsername(String username,String password){
        boolean username_present;
        boolean password_present;
        try{
            username_present= userRepo.findTopByUsername(username)!=null ? true:false;
            System.out.println("Username present "+ username_present);
            password_present=userRepo.findTopByPassword(password)!=null ? true:false;
            System.out.println("Password present "+password_present);

        }catch (NonUniqueResultException nre){
            return true;
        }

        return username_present && password_present;
    }

    public boolean findUserByUsername(String username){
        boolean username_present;
        try{
            username_present=userRepo.findTopByUsername(username)!=null ?true:false;
            System.out.println("Username present "+username_present);

        }catch (NonUniqueResultException nur){
            return true;
        }
        return username_present;
    }

    public void saveUser(User user){
        userRepo.save(user);
    }
}

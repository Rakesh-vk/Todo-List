package com.Rakesh.Todo.List.Repositories;

import com.Rakesh.Todo.List.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);

    User findTopByUsername(String username);

    User findTopByPassword(String password);
}

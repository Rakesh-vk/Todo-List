package com.Rakesh.Todo.List.Repositories;

import com.Rakesh.Todo.List.Models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long> {
    ToDo findByName( String Name);

    List<ToDo> findAllByUsername(String username);
}

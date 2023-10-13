package com.Rakesh.Todo.List.Controllers;

import com.Rakesh.Todo.List.Models.ToDo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.Rakesh.Todo.List.Services.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    private final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @PostMapping("/addToDoList")
    public ToDo addToDoList(@RequestBody ToDo toDo){
        logger.info("ToDo object {}",toDo.toString());
        return toDoService.saveToDoList(toDo);
    }

    @GetMapping("/ToDoList")
    public List<ToDo> getAllToDoList(){
        return toDoService.getToDoList();
    }

    @GetMapping("/ToDoListById/{id}")
    public ToDo findToDoById(@PathVariable  long id){
        return toDoService.getToDoListById(id);
    }

    @GetMapping("/ToDOListByName/{name}")
    public ToDo findToDoByName(@PathVariable String name){
        return toDoService.getToDoListByName(name);
    }

    @GetMapping("/ToDoListByUsername/{username}")
    public List<ToDo> findToDoListByUsername(@PathVariable String username){
        return toDoService.getToDoListForUser(username);
    }


    @PutMapping("/update")
    public ToDo updateToDoList(@RequestBody ToDo toDo){
        System.out.println("Updating");
        return toDoService.updateToDoList(toDo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteToDoList(@PathVariable long id){
        return toDoService.deleteToDoList(id);
    }
}

package com.Rakesh.Todo.List.Services;

import com.Rakesh.Todo.List.Models.ToDo;
import com.Rakesh.Todo.List.Repositories.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepo toDoRepo;

    public ToDo saveToDoList(ToDo toDo){
        System.out.println(toDo);
        return toDoRepo.save(toDo);
    }

    public List<ToDo> getToDoList(){
        return toDoRepo.findAll();
    }

    public ToDo getToDoListById(long id){
        return toDoRepo.findById(id).orElse(null);
    }

    public ToDo getToDoListByName(String name){
        return toDoRepo.findByName(name);
    }

    public List<ToDo > getToDoListForUser(String username){
        return toDoRepo.findAllByUsername(username);
    }

    public ToDo updateToDoList(ToDo toDo){
        System.out.println("Updating");
        ToDo exists=toDoRepo.findById(toDo.getId()).orElse(null);
        exists.setName(toDo.getName());
        exists.setStatus(toDo.isStatus());
        exists.setDescription(toDo.getDescription());

        return toDoRepo.save(exists);
    }

    public String deleteToDoList(long id){
        toDoRepo.deleteById(id);
        return id +" id->ToDoList removed/completed";
    }

}

package com.Rakesh.Todo.List.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ToDoDetails")
public class ToDo {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private boolean status;



    @Column(name = "username")
    private String username;
}

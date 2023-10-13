package com.Rakesh.Todo.List.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
@Id
@GeneratedValue
    private  long id;

    @Column(name="username" , unique = true)
    private String username;
    private String password;
}

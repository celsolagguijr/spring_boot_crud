
package com.example.crud_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int duration;

    // Note : mappedBy = "missions" should be the same as the variable name in the
    // User class
    @ManyToMany(mappedBy = "missions")
    private List<User> users;

}

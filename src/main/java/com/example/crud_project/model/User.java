package com.example.crud_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;

    // user has one address
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // many users to one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    // user has many missions
    // user_mission will be created to connect user and mission
    @JoinTable(name = "user_mission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "mission_id"))
    private List<Mission> missions;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

}

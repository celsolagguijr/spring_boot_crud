package com.example.crud_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_project.advices.Response;
import com.example.crud_project.advices.ResponseBuilder;
import com.example.crud_project.dto.user.UserDTO;
import com.example.crud_project.dto.user.UserFetchDTO;
import com.example.crud_project.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Response<List<UserDTO>>> getUsers() {
        List<UserDTO> users = this.userService.findAll();
        return ResponseEntity.ok(new ResponseBuilder<List<UserDTO>>().success().setData(users).build());
    }

    @GetMapping("/with-department")
    public ResponseEntity<Response<List<UserFetchDTO>>> getUsersWithDeparment() {
        List<UserFetchDTO> users = this.userService.findAllWithDeparment();
        return ResponseEntity.ok(new ResponseBuilder<List<UserFetchDTO>>().success().setData(users).build());
    }

    @GetMapping("/with-department-v2")
    public ResponseEntity<Response<List<UserFetchDTO>>> getUsersWithDeparment2() {
        List<UserFetchDTO> users = this.userService.findAllWithDeparment();
        return ResponseEntity.ok(new ResponseBuilder<List<UserFetchDTO>>().success().setData(users).build());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Response<UserDTO>> getUserByUsername(@PathVariable String username) {
        UserDTO result = this.userService.findByUsername(username);
        return ResponseEntity
                .ok(new ResponseBuilder<UserDTO>().success()
                        .setData(result).build());
    }

    @PostMapping()
    public ResponseEntity<Response<UserDTO>> addUser(@RequestBody @Valid UserDTO user) {
        UserDTO result = this.userService.save(user);
        return ResponseEntity
                .ok(new ResponseBuilder<UserDTO>().success()
                        .setData(result).build());

    }

    @PutMapping()
    public ResponseEntity<Response<UserDTO>> updateUsername(@RequestBody UserDTO user) {
        UserDTO result = this.userService.updateUserName(user);
        return ResponseEntity
                .ok(new ResponseBuilder<UserDTO>().success()
                        .setData(result).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> deleteUser(@PathVariable Long id) {
        UserDTO result = this.userService.deleteUser(id);
        return ResponseEntity
                .ok(new ResponseBuilder<UserDTO>().success()
                        .setData(result).build());

    }
}

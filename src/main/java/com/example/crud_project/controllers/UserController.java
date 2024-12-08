package com.example.crud_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_project.advices.APIResponse;
import com.example.crud_project.dto.UserDTO;
import com.example.crud_project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<APIResponse<List<UserDTO>>> getUsers() {
        List<UserDTO> users = this.userService.findAll();
        return ResponseEntity.ok(new APIResponse<List<UserDTO>>(true, "User List", users));

    }

    @GetMapping("/{username}")
    public ResponseEntity<APIResponse<UserDTO>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity
                .ok(new APIResponse<UserDTO>(true, "User Found", this.userService.findByUsername(username)));
    }

    @PostMapping()
    public ResponseEntity<APIResponse<UserDTO>> addUser(@RequestBody UserDTO user) {
        return ResponseEntity
                .ok(new APIResponse<UserDTO>(true, "User Found", this.userService.save(user)));

    }

    @PutMapping()
    public ResponseEntity<APIResponse<UserDTO>> updateUsername(@RequestBody UserDTO user) {
        return ResponseEntity
                .ok(new APIResponse<UserDTO>(true, "User Found", this.userService.updateUserName(user)));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<UserDTO>> deleteUser(@PathVariable Long id) {
        return ResponseEntity
                .ok(new APIResponse<UserDTO>(true, "User Found", this.userService.deleteUser(id)));

    }
}

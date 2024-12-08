package com.example.crud_project.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_project.dto.UserDTO;

@RestController
@RequestMapping("/v1")
public class BasicsController {

    @GetMapping("")
    public String getMapping() {
        return "This is get method";
    }

    @GetMapping(params = { "name" })
    public String getMappingWithParams(@RequestParam("name") String name) {
        return name;
    }

    @GetMapping(params = { "name", "lname" })
    public String getMappingWithParams(@RequestParam("name") String name,
            @RequestParam("lname") String lname) {
        return name + " " + lname;
    }

    @GetMapping("/with-path-variable/{name}")
    public String getMappingWithPathVariable(@PathVariable String name) {
        return name;
    }

    @GetMapping("/with-path-variable-using-map/{name}")
    public String getMappingWithPathVariable(@PathVariable Map<String, String> pathMap) {
        String name = pathMap.get("name");
        return name;
    }

    @PostMapping("")
    public String postMapping() {
        return "This is post method";
    }

    // @PostMapping("/with-request-body")
    // public UserDTO[] postMappingWithRequestBody(@RequestBody UserDTO user) {

    // var users = new ArrayList<UserDTO>();
    // users.add(user);

    // var user2 = new UserDTO();
    // user2.setName("John");
    // user2.setLname("Doe");
    // users.add(user2);

    // return users.toArray(new UserDTO[0]);
    // }

    @PutMapping("")
    public String putMapping() {
        return "This is put method";
    }

    @DeleteMapping("")
    public String deleteMapping() {
        return "This is delete method";
    }

}

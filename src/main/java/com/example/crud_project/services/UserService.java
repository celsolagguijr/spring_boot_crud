package com.example.crud_project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_project.dto.UserDTO;
import com.example.crud_project.exceptions.UserNotFoundException;
import com.example.crud_project.model.User;
import com.example.crud_project.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(user -> toUserDTO(user))
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO user) {
        return toUserDTO(repository.save(toEntity(user)));
    }

    public UserDTO findByUsername(String username) {
        // return repository.findByUsername(username).orElse(null);
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return toUserDTO(user);
    }

    public UserDTO updateUserName(UserDTO user) {
        User result = repository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        result.setUsername(user.getUsername());
        return toUserDTO(repository.save(result));
    }

    public UserDTO deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        repository.deleteById(id);
        return toUserDTO(user);

    }

    public UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}

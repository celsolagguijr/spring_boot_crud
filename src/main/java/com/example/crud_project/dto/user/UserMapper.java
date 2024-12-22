package com.example.crud_project.dto.user;

import java.util.function.Function;
import org.springframework.stereotype.Service;
import com.example.crud_project.model.User;

// basic mapping of model to DTO
@Service
public class UserMapper implements Function<User, UserFetchDTO> {

    @Override
    public UserFetchDTO apply(User user) {

        return new UserFetchDTO(
                user.getId(),
                user.getUsername(),
                user.getDepartment().getName());

    }

}

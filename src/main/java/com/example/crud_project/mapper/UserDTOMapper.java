package com.example.crud_project.mapper;

import com.example.crud_project.dto.user.UserFetchDTO;
import com.example.crud_project.dto.user.UserDTO;
import com.example.crud_project.model.User;

import org.mapstruct.MappingConstants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    @Mapping(source = "username", target = "name")
    @Mapping(source = "department.name", target = "department")
    UserFetchDTO mapToUserFetchDTO(User user);

    User mapToUser(UserDTO user);

}

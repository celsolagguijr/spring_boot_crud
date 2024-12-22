package com.example.crud_project.dto.user;

import com.example.crud_project.model.Department;

// public record UserFetchDTO(Long id,

// String username,
// Department Department) {
// }

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFetchDTO {
        private Long id;
        private String name;
        private String department;
}
package com.example.crud_project.dto.user;

// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// custom validation
import com.example.crud_project.validations.NotBlank;
import com.example.crud_project.validations.ExcludedUsername;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

    Long id;
    // @NotBlank(message = "Username is required")

    // custom validation
    @NotBlank(message = "Field is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @ExcludedUsername(excludedUsernames = { "user", "oztek" })
    String username;

}

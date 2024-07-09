package com.oreo.sample.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    List<CourseDTO> courseDTOs;
}

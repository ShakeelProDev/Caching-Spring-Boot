package com.oreo.sample.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
// import com.oreo.sample.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Long id;
    private String title;
    private String description;

}

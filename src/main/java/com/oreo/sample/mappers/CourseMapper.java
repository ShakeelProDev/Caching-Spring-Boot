package com.oreo.sample.mappers;

import com.oreo.sample.dtos.CourseDTO;
import com.oreo.sample.entity.Course;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {


    public CourseDTO toDto(Course course){
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        return dto;
    }

    public Course toEntity(CourseDTO courseDTO){
        Course course=new Course();
        course.setId(courseDTO.getId());
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        return course;
    }
}

package com.oreo.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreo.sample.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}

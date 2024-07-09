package com.oreo.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreo.sample.dtos.CourseDTO;
import com.oreo.sample.dtos.UserDTO;
import com.oreo.sample.entity.Course;
import com.oreo.sample.entity.User;
import com.oreo.sample.exception.ResourceNotFoundException;
import com.oreo.sample.mappers.CourseMapper;
import com.oreo.sample.mappers.UserMapper;
import com.oreo.sample.repository.CourseRepository;
import com.oreo.sample.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    private UserMapper userMapper;
    private CourseMapper courseMapper;


    
    public UserService(UserRepository userRepository, CourseRepository courseRepository, UserMapper userMapper, CourseMapper courseMapper) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.userMapper = userMapper;
        this.courseMapper = courseMapper;
    }
    
    public List<UserDTO> getAllUsers() {
        
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User User = userMapper.toEntity(userDTO);
        User = userRepository.save(User);
        return userMapper.toDto(User);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        User user = userMapper.toEntity(userDTO);
        user.setId(id);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO addCoursesToUser(Long userId, List<CourseDTO> courseDTOs) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        List<Course> courses = courseDTOs.stream().map(courseMapper::toEntity).collect(Collectors.toList());
        for (Course course : courses) {
            course.setUser(user);
        }
        courseRepository.saveAll(courses);
        user.getCourses().addAll(courses);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }
}


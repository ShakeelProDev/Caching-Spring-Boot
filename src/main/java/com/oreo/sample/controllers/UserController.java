package com.oreo.sample.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreo.sample.dtos.CourseDTO;
import com.oreo.sample.dtos.UserDTO;
// import com.oreo.sample.entity.Course;
import com.oreo.sample.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK)
                                  : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid  @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
                                      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/courses")
    public UserDTO addCoursesToUser(@PathVariable Long id, @RequestBody List<CourseDTO> courseDTOs) {
        return userService.addCoursesToUser(id, courseDTOs);
    }
}

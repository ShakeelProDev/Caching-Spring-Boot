package com.oreo.sample.mappers;

import com.oreo.sample.dtos.UserDTO;
import com.oreo.sample.entity.User;
import org.springframework.stereotype.Component;
// import org.mapstruct.Mapping;
// import org.mapstruct.factory.Mappers;

@Component
public class UserMapper {

    public UserDTO toDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    // @Mapping(target = "courses", source = "courseDTOs")
    public User toEntity(UserDTO userDTO){
        User user=new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}

package com.josval.backend.controller.mapper;

import com.josval.backend.model.dto.UserDTO;
import com.josval.backend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);

    //@Mapping(target = "id", ignore = true)
    //UserDTO createUserDTOWithoutId(User user);
}

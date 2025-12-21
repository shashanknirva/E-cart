package com.ecart.user_service.mapper;

import com.ecart.user_service.dto.UserDto;
import com.ecart.user_service.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapDtoToEntity(UserDto userDto){

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        return userEntity;

    }
    public UserDto mapEntityToDto(UserEntity userEntity){

        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        return userDto;

    }




}

package com.ecart.user_service.service;

import com.ecart.user_service.dto.UserDto;
import com.ecart.user_service.entity.UserEntity;
import com.ecart.user_service.exception.UserNotFoundException;
import com.ecart.user_service.mapper.UserMapper;
import com.ecart.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper userMapper;
    public UserDto saveUserDtls(UserDto userDto) {

        UserEntity userEntity = userMapper.mapDtoToEntity(userDto);
        UserEntity saveDtls = repository.save(userEntity);
        return userMapper.mapEntityToDto(saveDtls);

    }

    public UserDto getUserDetail(int id) {

       UserEntity userEntity = repository.findById(id).orElseThrow(()->  new UserNotFoundException("user not found"+ id));
        return userMapper.mapEntityToDto(userEntity);
    }
}

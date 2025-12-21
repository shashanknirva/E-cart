package com.ecart.user_service.controller;

import com.ecart.user_service.dto.UserDto;
import com.ecart.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/save")
    public ResponseEntity<Object> saveUserDtls(@RequestBody UserDto userDto){

        UserDto userDto1 = userService.saveUserDtls(userDto);
        if(userDto1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(userDto1);
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data not Inserted");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getUserDetail(@PathVariable int id){

        UserDto userDto = userService.getUserDetail(id);

        if(userDto!=null){
            return ResponseEntity.status(HttpStatus.FOUND).body(userDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found for id"+ id);
        }



    }


}

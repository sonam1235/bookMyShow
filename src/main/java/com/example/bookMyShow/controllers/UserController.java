package com.example.bookMyShow.controllers;

import com.example.bookMyShow.dtos.ResponseStatus;
import com.example.bookMyShow.dtos.SignUpRequestDTO;
import com.example.bookMyShow.dtos.SignUpResponseDTO;
import com.example.bookMyShow.models.User;
import com.example.bookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO){
        SignUpResponseDTO response = new SignUpResponseDTO();
        try{
            User user = userService.signUp(
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword()
            );
            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
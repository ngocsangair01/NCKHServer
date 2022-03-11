package com.example.nghiencuukhoahoctest.services;

import com.example.nghiencuukhoahoctest.dtos.UserDTO;
import com.example.nghiencuukhoahoctest.models.User;
import com.example.nghiencuukhoahoctest.payload.AuthenticationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface IUserService {
    User createUser(UserDTO userDTO);
    User deleteUserById(Integer id);
    Set<User> getAllUserByName(String name);
    User getUserByName(String name);
    Set<User> getAllUser();
    User login(AuthenticationRequest authenticationRequest);
    User editUserById(UserDTO userDTO,Integer id);
    User editAvatarUserById(MultipartFile file,Integer id);
    User editFrontIdCardUserById(MultipartFile file,Integer id);
    User editBackIdCardById(MultipartFile file,Integer id);
}

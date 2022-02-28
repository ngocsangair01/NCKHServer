package com.example.nghiencuukhoahoctest.services;

import com.example.nghiencuukhoahoctest.dtos.UserDTO;
import com.example.nghiencuukhoahoctest.models.User;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface IUserService {
    public User createUser(UserDTO userDTO);
    public User deleteUserById(Integer id);
    public Set<User> getAllUserByName(String name);
    public User getUserByName(String name);
    public Set<User> getAllUser();
}

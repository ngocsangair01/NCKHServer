package com.example.nghiencuukhoahoctest.utils;

import com.example.nghiencuukhoahoctest.dtos.*;
import com.example.nghiencuukhoahoctest.models.*;

import java.util.Locale;

public class ConvertDTOToDAO {
    public static User fromUserDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setPreName(userDTO.getPreName());
        user.setName(userDTO.getName());
        user.setBirthday(userDTO.getBirthday());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setSex(userDTO.getSex());
        user.setAvatar(userDTO.getAvatar());
        user.setAccount(userDTO.getAccount());
        user.setPassword(userDTO.getPassword());
        user.setFrontIdCard(userDTO.getFrontIdCard());
        user.setBackIdCard(userDTO.getBackIdCard());
        return user;
    }
    public static Traffic fromTrafficDTOToTraffic(TrafficDTO trafficDTO){
        Traffic traffic = new Traffic();
        traffic.setName(trafficDTO.getName());
        traffic.setType(trafficDTO.getType());
        traffic.setLicensePlate(trafficDTO.getLicensePlate());
        traffic.setColor(trafficDTO.getColor());
        traffic.setBrand(trafficDTO.getBrand());
        traffic.setCode(trafficDTO.getCode());
        traffic.setAvatar(trafficDTO.getAvatar());
        return traffic;
    }
    public static Borrower fromBorrowerDTOToBorrower(BorrowerDTO borrowerDTO){
        Borrower borrower = new Borrower();
        borrower.setCode(borrowerDTO.getCode());
        return borrower;
    }
    public static Role fromRoleDTOToRole(RoleDTO roleDTO){
        Role role = new Role();
        role.setName(roleDTO.getName());
        return role;
    }

}

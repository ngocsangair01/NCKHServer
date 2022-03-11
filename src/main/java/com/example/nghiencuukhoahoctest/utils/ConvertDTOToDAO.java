package com.example.nghiencuukhoahoctest.utils;

import com.example.nghiencuukhoahoctest.dtos.*;
import com.example.nghiencuukhoahoctest.models.*;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

public class ConvertDTOToDAO {

    public static User fromUserDTOToUser(User user, UserDTO userDTO){
        if (userDTO.getPreName() != null){
            user.setPreName(userDTO.getPreName());
        }
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getBirthday() != null) {
            user.setBirthday(userDTO.getBirthday());
        }
        if (userDTO.getPhone() != null) {
            user.setPhone(userDTO.getPhone());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getAddress() != null) {
            user.setAddress(userDTO.getAddress());
        }
        if (userDTO.getSex() != null) {
            user.setSex(userDTO.getSex());
        }
        user.setAccount(userDTO.getAccount());
        if (userDTO.getName() != null) {
            user.setPassword(userDTO.getPassword());
        }
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

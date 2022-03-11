package com.example.nghiencuukhoahoctest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String preName;
    private String name;
    private String birthday;
    private String phone;
    @Email(message = "regex not acp")
    private String email;
    private String address;
    private String sex;
    private String code;
    private MultipartFile avatar;
    private String account;
    private String password;
    private MultipartFile frontIdCard;
    private MultipartFile backIdCard;

}

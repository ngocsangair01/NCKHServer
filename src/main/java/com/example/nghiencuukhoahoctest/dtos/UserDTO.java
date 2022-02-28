package com.example.nghiencuukhoahoctest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//    @Email(message = "regex not acp")
    private String email;
    private String address;
    private String sex;
    private String code;
    private String avatar;
    private String account;
    private String password;
    private String frontIdCard;
    private String backIdCard;
    private String role;

    public UserDTO(String preName, String name, String birthday, String phone, String email, String address, String sex, String code, String avatar, String account, String password, String frontIdCard, String backIdCard) {
        this.preName = preName;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.code = code;
        this.avatar = avatar;
        this.account = account;
        this.password = password;
        this.frontIdCard = frontIdCard;
        this.backIdCard = backIdCard;
    }
}

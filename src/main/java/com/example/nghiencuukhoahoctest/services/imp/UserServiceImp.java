package com.example.nghiencuukhoahoctest.services.imp;

import com.example.nghiencuukhoahoctest.dtos.UserDTO;
import com.example.nghiencuukhoahoctest.exceptions.BadRequestException;
import com.example.nghiencuukhoahoctest.exceptions.NotFoundException;
import com.example.nghiencuukhoahoctest.models.User;
import com.example.nghiencuukhoahoctest.repositories.RoleRepository;
import com.example.nghiencuukhoahoctest.repositories.UserRepositories;
import com.example.nghiencuukhoahoctest.services.IUserService;
import com.example.nghiencuukhoahoctest.utils.ConvertDTOToDAO;
import com.github.slugify.Slugify;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SendMailServiceImp sendMailServiceImp;
    @Autowired
    private Slugify slugify;
    @Override
    public User createUser(UserDTO userDTO) {
        User oldUser = userRepositories.findByAccount(userDTO.getAccount());
        if (oldUser != null) {
            throw new BadRequestException("User already exists");
        }
        User oldUser2 = userRepositories.findByEmail(userDTO.getEmail());
        if (oldUser2 != null) {
            throw new BadRequestException("Email already exists");
        }
        User user =  ConvertDTOToDAO.fromUserDTOToUser(userDTO);
        String randomCode = RandomStringUtils.randomAlphanumeric(10);
        String code = userDTO.getPreName().concat("-").concat(userDTO.getName()).concat("-").concat(randomCode);
        user.setCode(slugify.slugify(code));
        user.setRole(roleRepository.findById(1).get());
        sendMailServiceImp.sendMailWithText("Hello","Đăng kí thành công, mật khẩu của bạn là: "+userDTO.getPassword(),userDTO.getEmail());
        return userRepositories.save(user);
    }

    @Override
    public User deleteUserById(Integer id) {
        Optional<User> oldUser = userRepositories.findById(id);
        if (oldUser.isEmpty()){
            throw new NotFoundException("Id khong ton tai");
        }
        userRepositories.deleteById(id);
        return oldUser.get();
    }

    @Override
    public Set<User> getAllUserByName(String name) {
        Set<User> users = new HashSet<>(userRepositories.findAllByName(name));
        if (users.isEmpty()) {
            throw new NotFoundException("Null");
        }
        return users;
    }

    @Override
    public User getUserByName(String name) {
        User user = userRepositories.findByName(name);
        if (user == null){
            throw new NotFoundException("No User");
        }
        return user;
    }

    @Override
    public Set<User> getAllUser() {
        Set<User> users =new HashSet<>(userRepositories.findAll()) ;
        if (users.size() == 0) {
            throw new NotFoundException("Null");
        }
        return users;
    }
}

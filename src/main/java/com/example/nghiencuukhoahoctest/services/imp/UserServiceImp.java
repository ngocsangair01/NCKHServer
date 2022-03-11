package com.example.nghiencuukhoahoctest.services.imp;

import com.example.nghiencuukhoahoctest.dtos.UserDTO;
import com.example.nghiencuukhoahoctest.exceptions.BadRequestException;
import com.example.nghiencuukhoahoctest.exceptions.NotFoundException;
import com.example.nghiencuukhoahoctest.models.User;
import com.example.nghiencuukhoahoctest.payload.AuthenticationRequest;
import com.example.nghiencuukhoahoctest.repositories.RoleRepository;
import com.example.nghiencuukhoahoctest.repositories.UserRepositories;
import com.example.nghiencuukhoahoctest.services.IUserService;
import com.example.nghiencuukhoahoctest.utils.ConvertDTOToDAO;
import com.example.nghiencuukhoahoctest.utils.UploadFile;
import com.github.slugify.Slugify;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    private UploadFile uploadFile;
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
        User user = new User();
        ConvertDTOToDAO.fromUserDTOToUser(user,userDTO);
        String randomCode = RandomStringUtils.randomAlphanumeric(10);
        String code = userDTO.getPreName().concat("-").concat(userDTO.getName()).concat("-").concat(randomCode);
        user.setCode(slugify.slugify(code));
        user.setRole(roleRepository.findById(1).get());
        user.setAvatar(uploadFile.getUrlFromFile(userDTO.getAvatar()));
        user.setFrontIdCard(uploadFile.getUrlFromFile(userDTO.getFrontIdCard()));
        user.setBackIdCard(uploadFile.getUrlFromFile(userDTO.getBackIdCard()));
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

    @Override
    public User login(AuthenticationRequest authenticationRequest) {
        User user = userRepositories.findByAccount(authenticationRequest.getUsername());
        if (user == null) {
            throw new NotFoundException("Wrong Account");
        }
        if (!user.getPassword().equals(authenticationRequest.getPassword())){
            throw new NotFoundException("Wrong Password");
        }
        return user;
    }

    @Override
    public User editUserById(UserDTO userDTO, Integer id) {
        User user = userRepositories.findById(id).get();
        if (user == null){
            throw new NotFoundException("Id khong dung");
        }
        return userRepositories.save(ConvertDTOToDAO.fromUserDTOToUser(user,userDTO));
    }

    @Override
    public User editAvatarUserById(MultipartFile file, Integer id) {
        User user = userRepositories.findById(id).get();
        if (user == null){
            throw new NotFoundException("Id khong dung");
        }
        user.setAvatar(uploadFile.getUrlFromFile(file));
        return userRepositories.save(user);
    }

    @Override
    public User editFrontIdCardUserById(MultipartFile file, Integer id) {
        User user = userRepositories.findById(id).get();
        if (user == null){
            throw new NotFoundException("Id khong dung");
        }
        user.setFrontIdCard(uploadFile.getUrlFromFile(file));
        return userRepositories.save(user);
    }

    @Override
    public User editBackIdCardById(MultipartFile file, Integer id) {
        User user = userRepositories.findById(id).get();
        if (user == null){
            throw new NotFoundException("Id khong dung");
        }
        user.setBackIdCard(uploadFile.getUrlFromFile(file));
        return userRepositories.save(user);
    }
}

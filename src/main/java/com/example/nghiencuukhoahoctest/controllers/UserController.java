package com.example.nghiencuukhoahoctest.controllers;

import com.example.nghiencuukhoahoctest.bases.BaseController;
import com.example.nghiencuukhoahoctest.dtos.UserDTO;
import com.example.nghiencuukhoahoctest.models.User;
import com.example.nghiencuukhoahoctest.services.IUserService;
import com.example.nghiencuukhoahoctest.services.imp.SendMailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User> {
    @Autowired
    private IUserService userService;

    @Autowired
    private SendMailServiceImp sendMailServiceImp;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        return this.resSuccess(userService.createUser(userDTO));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> findAllUser() {
        return this.resSetSuccess(userService.getAllUser());
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "idUser") Integer id) {
        return ResponseEntity.status(200).body(userService.deleteUserById(id));
    }

    @GetMapping("/get-all-by-name")
    public ResponseEntity<?> getAllUserByName(@RequestParam("name") String name){
        return ResponseEntity.status(200).body(userService.getAllUserByName(name));
    }
}

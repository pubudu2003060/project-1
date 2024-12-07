package com.example.project1.controller;

import com.example.project1.dto.UserDTO;
import com.example.project1.model.User;
import com.example.project1.repository.UserRepository;
import com.example.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getusers")
    public List<UserDTO> getUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/getuser/{id}")
    public UserDTO getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);

    }

    @PostMapping("/adduser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {

        return userService.addUser(userDTO);

    }

    @PutMapping("/edituser/{id}")
    public UserDTO editUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO) {
        return  userService.editUser(id,userDTO);
    }

    @DeleteMapping("/deleteuser/{id}")
    public UserDTO deleteUSer(@PathVariable("id") int id){
        return  userService.deleteUser(id);
    }

}

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
    public List<UserDTO> getUsers(){
        int k;
        return userService.getAllUsers();
    }

//    @Autowired
//    UserRepository userRepository;
//
//    @PostMapping("/adduser")
//    public User addUser(@RequestBody User user){
//        userRepository.save(user);
//
//        return user;
//    }
//
//    @GetMapping("/getusers")
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/getuser/{id}")
//    public Optional<User> getUserById(@PathVariable("id") int id) {
//        return userRepository.findById(id);
//
//    }
//
//    @PutMapping("/edituser/{id}")
//    public ResponseEntity<?> editUser(@PathVariable("id") int id, @RequestBody User user) {
//        User currentUser = userRepository.findById(id).orElse(null);
//        if (currentUser == null) {
//            return ResponseEntity.notFound().build(); // Return 404 if user not found
//        }
//        currentUser.setName(user.getName());
//        currentUser.setEmail(user.getEmail());
//        currentUser.setStatus(user.getStatus());
//        return ResponseEntity.ok(userRepository.save(currentUser));
//    }
//
//    @DeleteMapping("/deleteuser/{id}")
//    public User deleteUSer(@PathVariable("id") int id){
//
//        User user = userRepository.findById(id).orElse(null);
//
//        User deleteuser = user;
//
//        userRepository.delete(user);
//
//        return deleteuser;
//    }


}

package com.example.project1.service;


import com.example.project1.dto.UserDTO;
import com.example.project1.model.User;
import com.example.project1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    public UserDTO addUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO getUserById(int id) {
        return modelMapper.map(userRepository.findById(id), UserDTO.class);
    }

    public UserDTO editUser(int id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = modelMapper.map(userDTO, User.class);
            user.setId(id);
            userRepository.save(user);
            return modelMapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }

    public UserDTO deleteUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return modelMapper.map(user, UserDTO.class);
    }

}

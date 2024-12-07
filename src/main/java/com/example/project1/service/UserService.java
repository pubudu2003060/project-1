package com.example.project1.service;


import com.example.project1.dto.UserDTO;
import com.example.project1.model.User;
import com.example.project1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){

        List<User> userList = userRepository.findAll();

        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

}

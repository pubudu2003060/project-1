package com.example.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private String status;
}

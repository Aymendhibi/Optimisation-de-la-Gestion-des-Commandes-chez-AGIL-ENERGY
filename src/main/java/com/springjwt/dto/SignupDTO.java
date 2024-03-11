package com.springjwt.dto;

import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class SignupDTO {

    private String name;

    private String email;

    private String password;
    @Enumerated
    com.springjwt.entities.role role;


}

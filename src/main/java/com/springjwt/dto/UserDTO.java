package com.springjwt.dto;

import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;
    @Enumerated
    com.springjwt.entities.role role;


}

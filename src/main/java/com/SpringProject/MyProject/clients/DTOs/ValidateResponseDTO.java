package com.SpringProject.MyProject.clients.DTOs;

import com.SpringProject.MyProject.clients.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ValidateResponseDTO {
    private Long userId;
    private String email;
    private List<Role> roles;
}

package com.SpringProject.MyProject.clients.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateRequestDTO {
    private Long userId;
    private String token;
}

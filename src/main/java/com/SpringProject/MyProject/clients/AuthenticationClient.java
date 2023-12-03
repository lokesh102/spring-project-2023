package com.SpringProject.MyProject.clients;

import com.SpringProject.MyProject.clients.DTOs.ValidateRequestDTO;
import com.SpringProject.MyProject.clients.DTOs.ValidateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

public class AuthenticationClient {
    public ValidateResponseDTO getAuthentication(String token, Long userId){
        ValidateRequestDTO validateRequestDTO = new ValidateRequestDTO();
        validateRequestDTO.setToken(token);
        validateRequestDTO.setUserId(userId);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ValidateResponseDTO> validateResponseDTO = restTemplate.postForEntity("http://localhost:9000/auth/validate",validateRequestDTO,ValidateResponseDTO.class);
        return validateResponseDTO.getBody();
    }
}

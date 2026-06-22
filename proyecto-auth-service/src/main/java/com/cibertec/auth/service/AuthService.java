package com.cibertec.auth.service;

import com.cibertec.auth.dto.request.LoginRequestDTO;
import com.cibertec.auth.dto.request.RegisterRequestDTO;
import com.cibertec.auth.dto.response.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO loginRequest);
    AuthResponseDTO register(RegisterRequestDTO registerRequest);
}
package com.basic.board.controller;

import com.basic.board.model.DTO.AuthDto;
import com.basic.board.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto.Request authRequest) {
        String jwtToken = authService.authenticateUser(authRequest.getUsername(), authRequest.getPassword());
        AuthDto.Response authResponse = new AuthDto.Response(jwtToken);
        return ResponseEntity.ok(authResponse);
    }
}

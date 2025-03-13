package com.basic.board.controller;

import com.basic.board.model.DTO.AuthDto;
import com.basic.board.model.DTO.RegistDto;
import com.basic.board.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto.Request request) {
        AuthDto.Response response = authService.authenticateUser(request.getUserId(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/regist/idCheck")
    public ResponseEntity<?> idDuplicationCheck(@RequestParam String userId) {
        boolean isDuplicated = authService.duplicationCheckUserId(userId);
        RegistDto.IdCheckResponse response = new RegistDto.IdCheckResponse(!isDuplicated);
        response.setMessage(!isDuplicated);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/regist")
    public ResponseEntity<?> regist(@Valid @RequestBody RegistDto.RegistRequest request) {
        authService.registerUser(request);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}

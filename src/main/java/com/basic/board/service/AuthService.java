package com.basic.board.service;

import com.basic.board.config.jwt.JwtService;
import com.basic.board.model.Entity.User;
import com.basic.board.service.DAO.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public String authenticateUser(String username, String password) {
        // 사용자가 존재하는지 먼저 확인
        User user = userRepository.findByUserId(username);
        if (user == null) {
            throw new UsernameNotFoundException(""); // 오류 메시지는 글로벌 처리
        }

        // 사용자 인증
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 인증 성공 시 JWT 토큰 생성
        String jwtToken = jwtService.generateToken(username);

        return jwtToken;
    }
}

package com.basic.board.service;

import com.basic.board.config.jwt.JwtService;
import com.basic.board.model.DTO.AuthDto;
import com.basic.board.model.DTO.RegistDto;
import com.basic.board.model.Entity.RoleType;
import com.basic.board.model.Entity.User;
import com.basic.board.service.DAO.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthDto.Response authenticateUser(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        // 사용자가 존재하는지 먼저 확인
        if (user == null) {
            throw new UsernameNotFoundException(""); // 오류 메시지는 글로벌 처리
        }

        // 사용자 인증
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userId, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 인증 성공 시 JWT 토큰 생성
        String jwtToken = jwtService.generateToken(userId);
        AuthDto.Response response = new AuthDto.Response(user.getUserId(), user.getUserName(), jwtToken);
        return response;
    }

    public boolean duplicationCheckUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    public void registerUser(RegistDto.RegistRequest request) {
        // 중복 체크
        if(userRepository.existsByUserId(request.getUserId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        RoleType roleType = RoleType.fromString(request.getUserRole());

        User user = User.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .userName(request.getUserName())
                .userRole(roleType)
                .build();

        userRepository.save(user);
    }
}

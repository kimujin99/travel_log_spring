package com.basic.board.config.security;

import com.basic.board.model.Entity.User;
import com.basic.board.service.DAO.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(username);

        // DB에서 조회한 사용자 정보로 UserDetails 생성
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getUserRole().name()));

        return new CustomUserDetails(
                user.getUserId(),
                user.getPassword(),
                authorities,
                true,  // accountNonExpired
                true,  // accountNonLocked
                true,  // credentialsNonExpired
                true   // enabled
        );
    }
}
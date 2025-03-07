package com.basic.board.config.security;

import com.basic.board.model.Entity.User;
import com.basic.board.service.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(username);

        // DB에서 조회한 사용자 정보로 UserDetails 생성
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getUserRole().name()));


        return null;
    }
}
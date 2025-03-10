package com.basic.board.config;

import com.basic.board.model.DTO.AuthDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<AuthDto.Response> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        AuthDto.Response response = new AuthDto.Response("존재하지 않는 사용자입니다.2");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<AuthDto.Response> handleBadCredentialsException(BadCredentialsException ex) {
        AuthDto.Response response = new AuthDto.Response("비밀번호가 잘못됐습니다.2");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // 그 외의 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류 발생");
    }
}

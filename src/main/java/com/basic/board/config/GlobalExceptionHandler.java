package com.basic.board.config;

import com.basic.board.model.DTO.MessageDto;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<MessageDto> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        MessageDto response = new MessageDto("존재하지 않는 사용자입니다.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<MessageDto> handleBadCredentialsException(BadCredentialsException ex) {
        MessageDto response = new MessageDto("비밀번호가 일치하지 않습니다.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // 요청 파라미터(폼) 검증
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        MessageDto response = new MessageDto(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 필수 파라미터 누락 (400 Bad Request)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
        String paramName = ex.getParameterName();
        MessageDto response = new MessageDto(paramName + " 필수 파라미터가 필요합니다.");
        return ResponseEntity.badRequest().body(response);
    }

    // 접근 권한 없음 (403 Forbidden)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex) {
        MessageDto response = new MessageDto("접근 권한이 없습니다.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    // 인증 오류 (401 Unauthorized)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException ex) {
        MessageDto response = new MessageDto("인증이 필요합니다. 로그인 후 이용해줏세요.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // NullPointerException 처리 (필수 값 누락)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException ex) {
        MessageDto response = new MessageDto("잘못된 요청입니다. 필수 값이 없습니다.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // DB 오류 (500 Internal Server Error)
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDatabaseException(DataAccessException ex) {
        MessageDto response = new MessageDto("데이터베이스 오류가 발생했습니다. 관리자에게 문의하세요.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // 기타 예외 처리 (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> handleGenericException(Exception ex) {
        MessageDto response = new MessageDto("서버 오류가 발생했습니다. 관리자에게 문의해주세요.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

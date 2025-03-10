package com.basic.board.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AuthDto {
    @Getter
    @Setter
    public static class Request {
        private String username;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private String token;
    }
}

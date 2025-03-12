package com.basic.board.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class RegistDto {
    @Getter
    @Setter
    public static class RegistRequest {
        @NotBlank(message = "아이디는 필수 입력 항목입니다.")
        @Size(min = 5, max = 20, message = "아이디는 5~20자여야 합니다.")
        private String userId;

        @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
        @Size(min = 8, max = 16, message = "비밀번호는 8~16자여야 합니다.")
        private String password;

        @NotBlank(message = "이름은 필수 입력 항목입니다.")
        @Size(min = 2, max = 15, message = "이름은 2~15자여야 합니다.")
        private String userName;

        @NotBlank(message = "사용자 권한은 필수 입력 항목입니다.")
        private String userRole;
    }

    @Getter
    public static class IdCheckResponse {
        private boolean result;
        private String message;

        public IdCheckResponse(boolean result) {
            this.result = result;
        }

        public String setMessage(boolean result) {
            String message = "";
            if(result) message = "사용 가능한 아이디입니다.";
            else message = "이미 사용 중인 아이디입니다.";
            return this.message = message;
        }
    }
}

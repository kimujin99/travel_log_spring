package com.basic.board.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CountryDto {
    @Getter
    @Setter
    public static class Request {
        private String isoAlpha2;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private String isoAlpha2;
        private String isoAlpha3;
        private String koreanName;
        private String englishName;
        private String visaRequirement;
        private String voltage;
    }
}

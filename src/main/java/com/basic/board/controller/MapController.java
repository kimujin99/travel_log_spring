package com.basic.board.controller;

import com.basic.board.model.DTO.CountryDto;
import com.basic.board.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("/searchCountry")
    public ResponseEntity<?> searchCountryInfo (@RequestParam String isoAlpha2) {
        try {
            CountryDto.Response response = mapService.searchCountryInfo(isoAlpha2);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 서버 콘솔에 오류 로그 출력
            System.err.println("🔥 오류 발생: " + e.getMessage());
            e.printStackTrace();  // 스택 트레이스 출력
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버에서 오류가 발생했습니다.");
        }
    }
}

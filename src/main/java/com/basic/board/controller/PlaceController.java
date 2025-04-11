package com.basic.board.controller;

import com.basic.board.model.DTO.ApiResponse;
import com.basic.board.model.DTO.CountryInfoDto;
import com.basic.board.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/searchCountryInfo")
    public ResponseEntity<?> searchCountryInfo (@RequestParam String isoAlpha2) {
        try {
            ApiResponse<CountryInfoDto.CombinedResponse> response = placeService.searchCountryInfo(isoAlpha2);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("🔥 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버에서 오류가 발생했습니다.");
        }
    }
}

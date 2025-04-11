package com.basic.board.service;

import com.basic.board.model.DTO.ApiResponse;
import com.basic.board.model.DTO.CountryInfoDto;
import com.basic.board.model.Entity.Country;
import com.basic.board.model.Entity.CountryDetails;
import com.basic.board.service.DAO.CountryDetailsRepository;
import com.basic.board.service.DAO.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final CountryRepository countryRepository;
    private final CountryDetailsRepository countryDetailsRepository;

    // ✅ iso 국가 코드로 국가 정보 검색
    public ApiResponse<CountryInfoDto.CombinedResponse> searchCountryInfo(String isoAlpha2) {
        Country basic = countryRepository.findByIsoAlpha2(isoAlpha2);
        CountryDetails details = countryDetailsRepository.findByIsoAlpha2(isoAlpha2);

        if (basic == null && details == null) {
            return ApiResponse.error("해당 국가 정보가 존재하지 않습니다.");
        }

        // dto 개별 생성
        CountryInfoDto.BasicResponse basicDto = (basic != null) ?
                CountryInfoDto.BasicResponse.from(basic) : null;
        CountryInfoDto.DetailsResponse detailsDto = (details != null) ?
                CountryInfoDto.DetailsResponse.from(details) : null;

        // dto 합치기
        CountryInfoDto.CombinedResponse combinedDto = new CountryInfoDto.CombinedResponse(
                basicDto,
                detailsDto
        );

        return ApiResponse.success(combinedDto);
    }
}
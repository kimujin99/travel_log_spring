package com.basic.board.service;

import com.basic.board.model.DTO.CountryDto;
import com.basic.board.model.Entity.Country;
import com.basic.board.service.DAO.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapService {

    private final CountryRepository countryRepository;

    // ✅ iso 국가 코드로 상세 정보 검색
    public CountryDto.Response searchCountryInfo(String isoAlpha2) {
        Country country = countryRepository.findByIsoAlpha2(isoAlpha2);
        return new CountryDto.Response(
                country.getIsoAlpha2(),
                country.getIsoAlpha3(),
                country.getKoreanName(),
                country.getEnglishName(),
                country.getVisaRequirement(),
                country.getVoltage()
        );
    }
}
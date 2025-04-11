package com.basic.board.model.DTO;

import com.basic.board.model.Entity.Country;
import com.basic.board.model.Entity.CountryDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CountryInfoDto {
    @Getter
    @Builder
    public static class BasicResponse {
        private String iso;
        private String isoAlpha2;
        private String isoAlpha3;
        private String continentEnName;
        private String continentKrName;
        private String countryEnName;
        private String countryKrName;

        public static BasicResponse from(Country basic) {
            return BasicResponse.builder()
                    .iso(basic.getIso())
                    .isoAlpha2(basic.getIsoAlpha2())
                    .isoAlpha3(basic.getIsoAlpha3())
                    .continentEnName(basic.getContinentEnName())
                    .continentKrName(basic.getContinentKrName())
                    .countryEnName(basic.getCountryEnName())
                    .countryKrName(basic.getCountryKrName())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class DetailsResponse {
        private String isoAlpha2;
        private String capital;
        private String population;
        private String populationInfo;
        private String area;
        private String areaInfo;
        private String language;
        private String religion;
        private String nation;
        private String climate;
        private String foundation;
        private String visaExemption;
        private String visaExemptionInfo;
        private String voltage;
        private String plugType;

        public static DetailsResponse from(CountryDetails details) {
            return DetailsResponse.builder()
                    .isoAlpha2(details.getIsoAlpha2())
                    .capital(details.getCapital())
                    .population(details.getPopulation())
                    .populationInfo(details.getPopulationInfo())
                    .area(details.getArea())
                    .areaInfo(details.getAreaInfo())
                    .language(details.getLanguage())
                    .religion(details.getReligion())
                    .nation(details.getNation())
                    .climate(details.getClimate())
                    .foundation(details.getFoundation())
                    .visaExemption(details.getVisaExemption())
                    .visaExemptionInfo(details.getVisaExemptionInfo())
                    .voltage(details.getVoltage())
                    .plugType(details.getPlugType())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class CombinedResponse {
        private BasicResponse basic;
        private DetailsResponse details;
    }
}

package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="COUNTRY_DETAILS"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String isoAlpha2;
    @Column
    private String capital;
    @Column
    private String population;
    @Column
    private String populationInfo;
    @Column
    private String area;
    @Column
    private String areaInfo;
    @Column
    private String language;
    @Column
    private String religion;
    @Column
    private String nation;
    @Column
    private String climate;
    @Column
    private String foundation;
    @Column
    private String visaExemption;
    @Column
    private String visaExemptionInfo;
    @Column
    private String voltage;
    @Column
    private String plugType;

    @Builder
    public CountryDetails(String isoAlpha2, String capital, String population, String populationInfo, String area, String areaInfo, String language, String religion, String nation, String climate, String foundation, String visaExemption, String visaExemptionInfo, String voltage, String plugType) {
        this.isoAlpha2 = isoAlpha2;
        this.capital = capital;
        this.population = population;
        this.populationInfo = populationInfo;
        this.area = area;
        this.areaInfo = areaInfo;
        this.language = language;
        this.religion = religion;
        this.nation = nation;
        this.climate = climate;
        this.foundation = foundation;
        this.visaExemption = visaExemption;
        this.visaExemptionInfo = visaExemptionInfo;
        this.voltage = voltage;
        this.plugType = plugType;
    }
}

package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="COUNTRIES"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String iso;
    @Column(nullable = false)
    private String isoAlpha2;
    @Column(nullable = false)
    private String isoAlpha3;
    @Column(nullable = false)
    private String continentEnName;
    @Column(nullable = false)
    private String continentKrName;
    @Column(nullable = false)
    private String countryEnName;
    @Column(nullable = false)
    private String countryKrName;

    @Builder
    public Country(String iso, String isoAlpha2, String isoAlpha3, String continentEnName, String continentKrName, String countryEnName, String countryKrName) {
        this.iso = iso;
        this.isoAlpha2 = isoAlpha2;
        this.isoAlpha3 = isoAlpha3;
        this.continentEnName = continentEnName;
        this.continentKrName = continentKrName;
        this.countryEnName = countryEnName;
        this.countryKrName = countryKrName;
    }
}

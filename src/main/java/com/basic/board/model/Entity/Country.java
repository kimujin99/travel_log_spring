package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="countries"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String isoAlpha2;
    @Column(nullable = false)
    private String isoAlpha3;
    @Column(nullable = false)
    private String englishName;
    @Column(nullable = false)
    private String koreanName;

    @Builder
    public Country(String isoAlpha2, String isoAlpha3, String englishName, String koreanName) {
        this.isoAlpha2 = isoAlpha2;
        this.isoAlpha3 = isoAlpha3;
        this.englishName = englishName;
        this.koreanName = koreanName;
    }
}

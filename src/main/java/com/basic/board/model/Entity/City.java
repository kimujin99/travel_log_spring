package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="cities"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String isoAlpha2;
    @Column(nullable = false)
    private String englishName;
    @Column(nullable = false)
    private String koreanName;

    @Builder
    public City(String isoAlpha2, String englishName, String koreanName) {
        this.isoAlpha2 = isoAlpha2;
        this.englishName = englishName;
        this.koreanName = koreanName;
    }
}

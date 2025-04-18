package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="CITIES"
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
    private String cityEnName;
    @Column(nullable = false)
    private String cityKrName;

    @Builder
    public City(String isoAlpha2, String cityEnName, String cityKrName) {
        this.isoAlpha2 = isoAlpha2;
        this.cityEnName = cityEnName;
        this.cityKrName = cityKrName;
    }
}

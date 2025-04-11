package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
        name="TRAVEL_PLAN"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TravelPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String categoryCode;
    @Column(nullable = false)
    private Long countrySn;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate fromDate;
    @Column(nullable = false)
    private LocalDate toDate;
    @Column(nullable = false)
    private int travelers;
    @Column(length = 400)
    private String content;

    @Builder
    public TravelPlan(String categoryCode, Long countrySn, String title, LocalDate fromDate, LocalDate toDate, int travelers, String content) {
        this.categoryCode = categoryCode;
        this.countrySn = countrySn;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.travelers = travelers;
        this.content = content;
    }
}

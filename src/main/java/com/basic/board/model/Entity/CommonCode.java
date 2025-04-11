package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="COMMON_CODE"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String groupCode;
    @Column(nullable = false)
    private String Code;
    @Column(nullable = false)
    private String CodeName;
    @Column
    private String remark;

    @Builder
    public CommonCode(String groupCode, String Code, String CodeName, String remark) {
        this.groupCode = groupCode;
        this.Code = Code;
        this.CodeName = CodeName;
        this.remark = remark;
    }
}

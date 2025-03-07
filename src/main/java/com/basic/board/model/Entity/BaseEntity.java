package com.basic.board.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Column
    private String creator;
    @Column
    private LocalDateTime createDt;
    @Column
    private String modifier;
    @Column
    private LocalDateTime modifyDt;

    @PrePersist
    public void onCreate() {
        this.createDt = LocalDateTime.now();
        this.creator = getCurrentUser();
    }

    @PreUpdate
    public void onUpdate() {
        this.modifyDt = LocalDateTime.now();
        this.modifier = getCurrentUser();
    }

    protected String getCurrentUser() {
        return "unknown";  // 인증되지 않은 경우
    }
}

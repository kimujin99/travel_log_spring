package com.basic.board.model.Entity;

public enum RoleType {
    ROLE_USER("일반 사용자"),
    ROLE_ADMIN("관리자");

    private final String description;

    RoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // String을 enum으로 변환하는 메서드
    public static RoleType fromString(String role) {
        for (RoleType userRole : RoleType.values()) {
            if (userRole.name().equals(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("알 수 없는 권한: " + role);
    }
}

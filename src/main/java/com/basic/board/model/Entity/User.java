package com.basic.board.model.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="USERS",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_user_userId", columnNames = "userId")
    }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType userRole;

    @Builder
    public User(String userId,String password, String userName, RoleType userRole) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }
}
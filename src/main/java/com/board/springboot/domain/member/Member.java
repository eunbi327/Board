package com.board.springboot.domain.member;

import com.board.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String name, String password, String email, String picture, Role role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Member update(String name, String password) {
        this.name = name;
        this.password = password;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

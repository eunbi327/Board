package com.board.springboot.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "비회원"),
    USER("ROLE_MEMBER", "일반 회원"),
    SOCIAL("ROLE_SOCIAL_MEMBER", "소셜 회원");

    private final String key;
    private final String title;
}

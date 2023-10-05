package com.board.springboot.config.auth.dto;

import com.board.springboot.domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}

package com.board.springboot.domain.member.dto;

import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRegisterRequestDto {
    private String email;
    private String name;
    private String password;
    private String confirmPassword;

    @Builder
    public MemberRegisterRequestDto(String email, String name, String password, String confirmPassword) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .role(Role.USER)
                .build();
    }

    public boolean getConfirmPassword() {
        return password.equals(confirmPassword);
    }
}

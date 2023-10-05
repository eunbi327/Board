package com.board.springboot.domain.member.dto;

import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class MemberRegisterRequestDto {
    @NotBlank(message = "이메일을 입력하세요.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "올바른 이메일 형식을 사용하세요.")
    private String email;

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "특수문자를 제외한 2~10자리를 사용하세요.")
    private String name;

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
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

    public boolean isConfirmPasswordValid() {
        return password.equals(confirmPassword);
    }
}

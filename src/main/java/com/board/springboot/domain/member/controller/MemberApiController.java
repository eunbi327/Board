package com.board.springboot.domain.member.controller;

import com.board.springboot.config.auth.dto.OAuthAttributes;
import com.board.springboot.domain.member.dto.MemberRegisterRequestDto;
import com.board.springboot.domain.member.dto.MemberUpdateRequestDto;
import com.board.springboot.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public Long register(@RequestBody MemberRegisterRequestDto requestDto) {
        return memberService.register(requestDto);
    }

    @PutMapping("/api/members/{userId}")
    public Long update(@PathVariable Long userId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.update(userId, requestDto);
    }
}

package com.board.springboot.domain.member.service;

import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.member.MemberRepository;
import com.board.springboot.domain.member.dto.MemberRegisterRequestDto;
import com.board.springboot.domain.member.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long register(MemberRegisterRequestDto requestDto) {
        String email = requestDto.getEmail();
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 등록된 이메일 주소입니다.");
        }

        if (!requestDto.isConfirmPasswordValid()) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        return memberRepository.save(requestDto.toEntity()).getUserId();
    }

    @Transactional
    public Long update(Long userId, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다."));
        member.update(requestDto.getName(), requestDto.getPassword());

        return userId;
    }
}

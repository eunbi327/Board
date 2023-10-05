package com.board.springboot.domain.member;

import com.board.springboot.domain.posts.Posts;
import com.board.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup() {
        memberRepository.deleteAll();
    }

    @Test
    public void 회원저장_불러오기() {
        // given
        String email = "test@email.com";
        String nickname = "testnick";

        memberRepository.save(Member.builder()
                .email(email)
                .nickname(nickname)
                .password("Test01!")
                .role(Role.USER)
                .build());

        // when
        List<Member> memberList = memberRepository.findAll();

        // then
        Member member = memberList.get(0);
        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getNickname()).isEqualTo(nickname);
    }

}

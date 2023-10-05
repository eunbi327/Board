package com.board.springboot.domain.member.controller;

import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.member.MemberRepository;
import com.board.springboot.domain.member.Role;
import com.board.springboot.domain.member.dto.MemberRegisterRequestDto;
import com.board.springboot.domain.member.dto.MemberUpdateRequestDto;
import com.board.springboot.domain.posts.Posts;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private MemberRepository memberRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Member_회원가입() throws Exception {
        // TODO : 비밀번호 불일치 로직 테스트 코드 고치기
        // given
        String email = "test@email.com";
        String name = "testnick";
        String password = "Test01!";
        MemberRegisterRequestDto requestDto = MemberRegisterRequestDto.builder()
                .email(email)
                .name(name)
                .password(password)
                .confirmPassword(password)
                .build();

        String url = "http://localhost:" + port + "/api/members";

        // when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        // then
        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getName()).isEqualTo(name);

        Member member = all.get(0);

        System.out.println(">>>>>> email = " + member.getEmail() + ", nickname = " + member.getName());
        System.out.println(">>>>>> password = " + member.getPassword() + ", confirmPassword = " + requestDto.getConfirmPassword());

    }

    @Test
    @WithMockUser(roles = "USER")
    public void Member_회원정보수정() throws Exception {
        // given
        Member memberRegister = memberRepository.save(Member.builder()
                .email("test@email.com")
                .name("testNick")
                .password("Test01!")
                .role(Role.USER)
                .build());

        Long updateId = memberRegister.getUserId();

        String expectedName = "nickname2";
        String expectedPassword = "Password2!";

        MemberUpdateRequestDto requestDto = MemberUpdateRequestDto.builder()
                .name(expectedName)
                .password(expectedPassword)
                .build();

        String url = "http://localhost:" + port + "/api/members/" + updateId;

        // when
        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        // then
        List<Member> all = memberRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getPassword()).isEqualTo(expectedPassword);
    }
}

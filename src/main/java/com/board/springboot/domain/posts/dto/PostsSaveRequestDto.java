package com.board.springboot.domain.posts.dto;

import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private int viewCount;
    private Member member;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, int viewCount, Member member) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount;
        this.member = member;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .viewCount(viewCount)
                .member(member)
                .build();
    }
}

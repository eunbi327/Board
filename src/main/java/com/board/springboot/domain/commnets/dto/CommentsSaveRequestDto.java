package com.board.springboot.domain.commnets.dto;

import com.board.springboot.domain.commnets.Comments;
import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String content;
    private String author;
    private Member member;
    private Posts posts;

    @Builder
    public CommentsSaveRequestDto(String content, String author, Member member, Posts posts) {
        this.content = content;
        this.author = author;
        this.member = member;
        this.posts = posts;
    }

    public Comments toEntity() {
        Comments comments = Comments.builder()
                .content(content)
                .author(author)
                .member(member)
                .posts(posts)
                .build();
        return comments;
    }
}

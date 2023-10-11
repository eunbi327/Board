package com.board.springboot.domain.posts.dto;

import com.board.springboot.domain.commnets.dto.CommentsResponseDto;
import com.board.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class PostsResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
    private int viewCount;
    private Long userId;
    private List<CommentsResponseDto> comments;

    public PostsResponseDto(Posts entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.viewCount = entity.getViewCount();
        this.userId = entity.getMember().getUserId();
        this.comments = entity.getComments().stream().map(CommentsResponseDto::new).collect(Collectors.toList());
    }
}

package com.board.springboot.domain.posts.dto;

import com.board.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostsResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
    private int viewCount;

    public PostsResponseDto(Posts entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.viewCount = entity.getViewCount();
    }
}

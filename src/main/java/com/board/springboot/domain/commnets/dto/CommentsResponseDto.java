package com.board.springboot.domain.commnets.dto;

import com.board.springboot.domain.commnets.Comments;
import lombok.Getter;

@Getter
public class CommentsResponseDto {

    private Long commentId;
    private String content;
    private String author;
    private Long postId;

    public CommentsResponseDto(Comments comments) {
        this.commentId = comments.getCommentId();
        this.content = comments.getContent();
        this.author = comments.getMember().getName();
        this.postId = comments.getPosts().getPostId();
    }
}

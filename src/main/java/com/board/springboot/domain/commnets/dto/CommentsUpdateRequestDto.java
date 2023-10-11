package com.board.springboot.domain.commnets.dto;

import com.board.springboot.domain.commnets.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsUpdateRequestDto {
    private String content;

    public Comments toEntity() {
        return Comments.builder()
                .content(content)
                .build();
    }
}

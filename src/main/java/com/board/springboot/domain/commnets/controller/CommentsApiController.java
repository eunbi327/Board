package com.board.springboot.domain.commnets.controller;

import com.board.springboot.config.auth.dto.LoginUser;
import com.board.springboot.config.auth.dto.SessionUser;
import com.board.springboot.domain.commnets.dto.CommentsResponseDto;
import com.board.springboot.domain.commnets.dto.CommentsSaveRequestDto;
import com.board.springboot.domain.commnets.dto.CommentsUpdateRequestDto;
import com.board.springboot.domain.commnets.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {
    private final CommentsService commentsService;

    @PostMapping("/api/comments/{postId}")
    public Long save(@PathVariable Long postId, @RequestBody CommentsSaveRequestDto requestDto, @LoginUser SessionUser member) {
        return commentsService.save(member.getName(), postId, requestDto);
    }

    @PutMapping("/api/comments/{commentId}")
    public Long update(@PathVariable Long commentId, @RequestBody CommentsUpdateRequestDto requestDto) {
        return commentsService.update(commentId, requestDto);
    }

    @GetMapping("/api/comments/{commentId}")
    public CommentsResponseDto findById(@PathVariable Long commentId) {
        return commentsService.findById(commentId);
    }

    @DeleteMapping("/api/comments/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentsService.delete(commentId);
    }
}

package com.board.springboot.domain.posts.controller;

import com.board.springboot.config.auth.dto.LoginUser;
import com.board.springboot.config.auth.dto.SessionUser;
import com.board.springboot.domain.posts.service.PostsService;
import com.board.springboot.domain.posts.dto.PostsResponseDto;
import com.board.springboot.domain.posts.dto.PostsSaveRequestDto;
import com.board.springboot.domain.posts.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto, @LoginUser SessionUser member) {
        return postsService.save(member.getName(), requestDto);
    }

    @PutMapping("/api/posts/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(postId, requestDto);
    }

    @GetMapping("/api/posts/{postId}")
    public PostsResponseDto findById(@PathVariable Long postId) {
        return postsService.findById(postId);
    }

    @DeleteMapping("/api/posts/{postId}")
    public Long delete(@PathVariable Long postId) {
        postsService.delete(postId);
        return postId;
    }
}

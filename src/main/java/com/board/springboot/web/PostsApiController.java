package com.board.springboot.web;

import com.board.springboot.service.PostsService;
import com.board.springboot.web.dto.PostsResponseDto;
import com.board.springboot.web.dto.PostsSaveRequestDto;
import com.board.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
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

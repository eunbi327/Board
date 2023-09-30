package com.board.springboot.service;

import com.board.springboot.domain.posts.Posts;
import com.board.springboot.domain.posts.PostsRepository;
import com.board.springboot.web.dto.PostsResponseDto;
import com.board.springboot.web.dto.PostsSaveRequestDto;
import com.board.springboot.web.dto.PostsUpdateRequestDto;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long postId, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 글 번호 : " + postId));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return postId;
    }

    public PostsResponseDto findById(Long postId) {
        Posts entity = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 글 번호 : " + postId));
        return new PostsResponseDto(entity);
    }
}


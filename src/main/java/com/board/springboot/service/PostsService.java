package com.board.springboot.service;

import com.board.springboot.domain.posts.Posts;
import com.board.springboot.domain.posts.PostsRepository;
import com.board.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public void delete(Long postId) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 글 번호 : " + postId));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long postId) {
        Posts entity = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 글 번호 : " + postId));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllByOrderByPostIdDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}


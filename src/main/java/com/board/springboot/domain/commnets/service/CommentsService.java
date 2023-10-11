package com.board.springboot.domain.commnets.service;

import com.board.springboot.config.auth.dto.SessionUser;
import com.board.springboot.domain.commnets.Comments;
import com.board.springboot.domain.commnets.CommentsRepository;
import com.board.springboot.domain.commnets.dto.CommentsResponseDto;
import com.board.springboot.domain.commnets.dto.CommentsSaveRequestDto;
import com.board.springboot.domain.commnets.dto.CommentsUpdateRequestDto;
import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.member.MemberRepository;
import com.board.springboot.domain.posts.Posts;
import com.board.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final MemberRepository memberRepository;
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(String author, Long postId, CommentsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 번호 : " + postId));

        Member member = memberRepository.findByName(author)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. 회원 이름 : " + author));

        requestDto.setAuthor(author);
        requestDto.setMember(member);
        requestDto.setPosts(posts);

        return commentsRepository.save(requestDto.toEntity()).getCommentId();
    }

    @Transactional
    public Long update(Long commentId, CommentsUpdateRequestDto requestDto) {
        Comments comments = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. 댓글 번호 : " + commentId));
        comments.update(requestDto.getContent());

        return commentId;
    }

    public CommentsResponseDto findById(Long commentId) {
        Comments entity = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. 댓글 번호 : " + commentId));
        return new CommentsResponseDto(entity);
    }

    public void delete(Long commentId) {
        Comments comments = commentsRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 글 번호 : " + commentId));

        commentsRepository.delete(comments);
    }

}

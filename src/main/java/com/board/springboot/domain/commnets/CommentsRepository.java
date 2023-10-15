package com.board.springboot.domain.commnets;

import com.board.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}

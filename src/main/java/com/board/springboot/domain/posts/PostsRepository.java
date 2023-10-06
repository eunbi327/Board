package com.board.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByOrderByPostIdDesc();

    @Modifying
    @Query("update Posts p set p.viewCount = p.viewCount + 1 where p.postId = :postId")
    int viewCount(Long postId);

}

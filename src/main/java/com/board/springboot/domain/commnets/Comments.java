package com.board.springboot.domain.commnets;

import com.board.springboot.domain.BaseTimeEntity;
import com.board.springboot.domain.member.Member;
import com.board.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 게시글, 사용자 엔티티와 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @Builder
    public Comments(String content, String author, Member member, Posts posts) {
        this.content = content;
        this.author = author;
        this.member = member;
        this.posts = posts;
    }

    public void update(String content) {
        this.content = content;
    }

}

package com.board.springboot.domain.posts;

import com.board.springboot.domain.BaseTimeEntity;
import com.board.springboot.domain.commnets.Comments;
import com.board.springboot.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private int viewCount;

    // 사용자 엔티티와 다대일 관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    // 댓글 엔티티와의 양방향 관계 설정
    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comments> comments;

    @Builder
    public Posts(String title, String content, String author, int viewCount, Member member) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount;
        this.member = member;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.yujeong.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(columnDefinition = "TEXT") // columnDefinition : DB에 생성될 컬럼의 SQL 타입을 직접 지정
    private String content; // 내용 : "TEXT" 긴 본문 저장

    // 연관관계 설정 시 서비스에서 찾아서 DTO로 주입
    private User user;
    private Board board;

    // private Long userId;
    // private Long boardId;
}

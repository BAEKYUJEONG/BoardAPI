package com.yujeong.board.dto;

import com.yujeong.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {

    private Long id;
    private String title;
    private String author;
    private String content;

    private Long userId;
    private Long boardId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Post 엔티티를 API 응답용 DTO로 변환한다.
     * user, board 등의 연관 엔티티는 LAZY 로딩일 수 있으나 id 조회는 안전하다.
     */
    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .userId(post.getUser().getId())
                .boardId(post.getBoard().getId())
                .build();
    }
}

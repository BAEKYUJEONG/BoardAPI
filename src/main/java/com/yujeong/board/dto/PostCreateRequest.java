package com.yujeong.board.dto;

import com.yujeong.board.entity.Board;
import com.yujeong.board.entity.Post;
import com.yujeong.board.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateRequest {
    private String title;
    private String content;
    private Long userId;
    private Long boardId;

    public Post toEntity(User user, Board board) {
        return Post.builder()
                .title(title)
                .author(user.getName())
                .content(content)
                .user(user)
                .board(board)
                .build();
    }
}
/*
import com.yujeong.board.entity.Board;
import com.yujeong.board.entity.Post;
import com.yujeong.board.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// DTO는 엔티티를 참조하지 않는다! 의존도 최소화
public class PostRequestDto {
    private String title;
    private String author;
    private String content;
    private Long userId;
    private Long boardId;

    // toEntity를 하지 말고 Service 단에서 Helper 메서드 or toEntity
    // 나중에 Business 단에서 Helper 메서드
    // user, board 를 서비스에서 만들어서 넣기
    public Post toEntity(User user, Board board) {
        return Post.builder()
                .title(this.title)
                .author(this.author)
                .content(this.content)
                .build();
    }
}
*/
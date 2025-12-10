package com.yujeong.board.dto;

import com.yujeong.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestDto {
    private String author;
    private String content;
    //private Long userId;
    private Long postId;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .build();
    }
}

package com.yujeong.board.dto;

import com.yujeong.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequest {
    private String name;

    public Board toEntity() {
        return Board.builder()
                .name(name)
                .build();
    }
}

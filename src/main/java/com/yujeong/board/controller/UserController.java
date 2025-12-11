package com.yujeong.board.controller;

import com.yujeong.board.dto.UserRequest;
import com.yujeong.board.dto.UserResponse;
import com.yujeong.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 사용자 생성 API.
     * HTTP Body 로 전달받은 UserRequestDto 기반으로 User 생성.
     */
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    /**
     * 사용자 단건 조회 API.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    /**
     * 전체 사용자 목록 조회 API.
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * 사용자 정보 업데이트 API.
     * PUT 메서드로 전체 필드를 갱신하는 목적.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequest request
    ) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    /**
     * 사용자 삭제 API.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

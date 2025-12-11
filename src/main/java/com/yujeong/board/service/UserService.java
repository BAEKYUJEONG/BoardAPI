package com.yujeong.board.service;

import com.yujeong.board.dto.UserRequest;
import com.yujeong.board.dto.UserResponse;
import com.yujeong.board.entity.User;
import com.yujeong.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    /**
     * 새로운 사용자를 생성한다.
     * UserRequestDto → User 엔티티 변환 후 저장하고, UserResponseDto로 반환한다.
     */
    public UserResponse createUser(UserRequest request) {
        User user = request.toEntity();
        User saved = userRepository.save(user);
        return UserResponse.from(saved);
    }

    /**
     * ID로 특정 사용자를 조회한다.
     * 존재하지 않을 경우 IllegalArgumentException 발생.
     */
    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserResponse.from(user);
    }

    /**
     * 전체 사용자 목록을 조회하고 ResponseDto로 변환한다.
     */
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }

    /**
     * 사용자 정보 업데이트.
     * 기존 엔티티 조회 → 수정된 필드 적용 → 저장.
     * (더 좋은 방식: 엔티티 자체에 update 메서드를 만들어 사용하는 것)
     */
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        User updated = User.builder()
                .id(user.getId())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(updated);
        return UserResponse.from(updated);
    }

    /**
     * ID 기준으로 사용자 삭제.
     * 존재하지 않아도 deleteById 내부에서 예외는 발생하지 않는다.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

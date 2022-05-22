package com.stopwaiting.server.service.user;

import com.stopwaiting.server.domain.user.User;
import com.stopwaiting.server.domain.user.UserRepository;
import com.stopwaiting.server.web.dto.UserResponseDto;
import com.stopwaiting.server.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        String encodedPassword =passwordEncoder.encode(userSaveRequestDto.getPassword());
        return userRepository.save(userSaveRequestDto.toEntity(encodedPassword)).getId();
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" + id));
        userRepository.delete(user);
    }

    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }
}

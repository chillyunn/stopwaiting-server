package com.stopwaiting.server.service;

import com.stopwaiting.server.domain.user.User;
import com.stopwaiting.server.domain.user.UserRepository;
import com.stopwaiting.server.domain.userqueue.UserQueue;
import com.stopwaiting.server.domain.userqueue.UserQueueRepository;
import com.stopwaiting.server.web.dto.user.*;
import com.stopwaiting.server.web.dto.userqueue.UserQueueResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserQueueRepository userQueueRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        String encodedPassword = passwordEncoder.encode(userSaveRequestDto.getPassword());
        return userRepository.save(userSaveRequestDto.toEntity(encodedPassword)).getId();
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" + id));
        userRepository.delete(user);
    }

    @Transactional
    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        Long id = requestDto.getId();
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" + id));
        entity.updateToken(requestDto.getToken());
        String password = requestDto.getPassword();
        if (!passwordEncoder.matches(password, entity.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        entity.updateToken(requestDto.getToken());

        return UserLoginResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
    @Transactional
    public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디의 회원정보가 없습니다."));
        user.update(userUpdateRequestDto.getPhoneNumber(),userUpdateRequestDto.getReported());
        return id;
    }
//    @Transactional
//    public Long updateToken(Long id, String token){
//        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디의 회원정보가 없습니다."));
//        user.updateToken(token);
//        return id;
//    }
    @Transactional
    public Long addReport(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디의 회원정보가 없습니다."));
        user.addReport();
        return id;
    }
    @Transactional
    public Long checkId(Long id){
        if(!userRepository.existsById(id))
            return id;
        else
            throw new IllegalArgumentException("중복된 아이디 입니다.");
    }
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

}

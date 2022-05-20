package com.stopwaiting.server.web.dto;

import com.stopwaiting.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class UserSaveRequestDto {
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;

    private PasswordEncoder passwordEncoder;

    @Builder
    public UserSaveRequestDto(Long id, String name, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    String encodedPassword=passwordEncoder.encode(password);
    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .password(encodedPassword)
                .phoneNumber(phoneNumber)
                .build();
    }
}

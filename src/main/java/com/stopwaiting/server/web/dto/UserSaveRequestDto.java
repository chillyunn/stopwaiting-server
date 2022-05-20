package com.stopwaiting.server.web.dto;

import com.stopwaiting.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;

    @Builder
    public UserSaveRequestDto(Long id, String name, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}

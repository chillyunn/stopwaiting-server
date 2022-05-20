package com.stopwaiting.server.web.dto;

import com.stopwaiting.server.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;

    public UserResponseDto(User entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.password=entity.getPassword();
        this.phoneNumber=entity.getPhoneNumber();
    }
}
